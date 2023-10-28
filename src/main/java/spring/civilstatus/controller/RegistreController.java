package spring.civilstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring.civilstatus.models.Registre;
import spring.civilstatus.service.RegistreService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class RegistreController {
	@Autowired
	private RegistreService registreService;

	@PostMapping(value = "/registre", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Registre> createRegistre(@Valid @RequestBody Registre registre) {
		Registre result = registreService.createRegistre(registre);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/registres", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Registre>> getAllRegistres() {
		List<Registre> result = registreService.getAllRegistres();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/registre/{registreId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Registre> getRegistreById(@PathVariable int registreId) {
		Registre result = registreService.getRegistre(registreId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/registre/type/{registreType}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Registre>> getRegistreByType(@PathVariable String registreType) {
		List<Registre> result = registreService.getRegistresPerType(registreType);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/registre/annexe/{annexeId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Registre>> getRegistreByAnnexe(@PathVariable int annexeId) {
		List<Registre> result = registreService.getRegistrePerAnnexe(annexeId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/registre/terme/{terme}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Registre>> getRegistreByTerme(@PathVariable String terme) {
		List<Registre> result = registreService.searchRegistre(terme);
		return ResponseEntity.ok().body(result);
	}

	@Operation(summary = "Delete a Registre")
	@DeleteMapping(value = "/registre/{registreId}")
	public ResponseEntity<Void> deleteRegistre(@PathVariable int registreId) {
		try {
			registreService.deleteRegistre(registreId);
			return ResponseEntity.noContent().build();
		} catch (DataIntegrityViolationException ex) {
			throw ex;
		}
	}

	@PutMapping(value = "/registre", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateRegistre(@Valid @RequestBody Registre registre) {
		registreService.updateRegistre(registre);
		return ResponseEntity.noContent().build();
	}
}