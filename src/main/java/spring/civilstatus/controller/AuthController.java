package spring.civilstatus.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import spring.civilstatus.jwt.JwtUtils;
import spring.civilstatus.jwt.payload.requests.LoginRequest;
import spring.civilstatus.jwt.payload.requests.SignupRequest;
import spring.civilstatus.jwt.payload.responses.MessageResponse;
import spring.civilstatus.jwt.payload.responses.UserInfoResponse;
import spring.civilstatus.models.Agent;
import spring.civilstatus.models.Annexe;
import spring.civilstatus.models.ERole;
import spring.civilstatus.models.Officier;
import spring.civilstatus.models.Role;
import spring.civilstatus.models.User;
import spring.civilstatus.repository.AnnexeRepository;
import spring.civilstatus.repository.RoleRepository;
import spring.civilstatus.repository.UserRepository;
import spring.civilstatus.service.ExcelService;
import spring.civilstatus.service.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AnnexeRepository annexeRepository;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	ExcelService excelService;
	String path = "C:\\\\Users\\\\Ihssane\\\\Desktop\\\\Stage d'été 2023\\\\Civil status data.xlsx";

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(
				new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		Map<String, String> emailRoleMap = excelService.readExcelFile(path);
		Map<String, String> lieuEmailMap = excelService.getLieuTravail(path);

		String email = signUpRequest.getEmail();
		String role = excelService.getRoleFromExcel(email, emailRoleMap);
		Annexe lieu = excelService.getLieu(email, lieuEmailMap);
		System.out.print(lieu);
		if (role == null) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Role not found for the provided email."));
		}

		// Assign the role obtained from Excel
		Role userRole = roleRepository.findByName(ERole.valueOf("ROLE_" + role.toUpperCase()))
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		Set<Role> roles = new HashSet<>();
		roles.add(userRole);
		User user;
		if (role.equalsIgnoreCase("officier")) {
			user = new Officier(signUpRequest.getUsername(), signUpRequest.getEmail(),
					encoder.encode(signUpRequest.getPassword()), lieu);
			System.out.print(user);
		} else if (role.equalsIgnoreCase("agent")) {
			user = new Agent(signUpRequest.getUsername(), signUpRequest.getEmail(),
					encoder.encode(signUpRequest.getPassword()), lieu);
			System.out.print(user);
		} else {
			user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
					encoder.encode(signUpRequest.getPassword()));
			System.out.print(user);
		}
		user.setRoles(roles);
		// Save the user
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new MessageResponse("You've been signed out!"));
	}
}