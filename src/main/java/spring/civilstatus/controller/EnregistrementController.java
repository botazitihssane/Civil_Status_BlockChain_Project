package spring.civilstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring.civilstatus.models.Enregistrement;
import spring.civilstatus.service.EnregistrementService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class EnregistrementController {
	@Autowired
	EnregistrementService enregistrementService;

	@PostMapping(value = "/enregistrement", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Enregistrement> createEnregistrement(@Valid @RequestBody Enregistrement enregistrement) {
		Enregistrement result = enregistrementService.addEnregistrement(enregistrement);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/enregistrements", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getAllEnregistrement() {
		List<Enregistrement> result = enregistrementService.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/enregistrements/agent/{agent}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getEnregistrementByAgent(@PathVariable String agent) {
		List<Enregistrement> result = enregistrementService.getEnregistrementByAgent(agent);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/enregistrements/registre/{registre}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getEnregistrementByRegistre(@PathVariable int registre) {
		List<Enregistrement> result = enregistrementService.getEnregistrementByRegistre(registre);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/enregistrements/id/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Enregistrement> getEnregistrementById(@PathVariable int id) {
		Enregistrement result = enregistrementService.getById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/acteDeces", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getActeDeces() {
		List<Enregistrement> result = enregistrementService.getActeDeces();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/acteNaissance", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getActeNaissance() {
		List<Enregistrement> result = enregistrementService.getActeNaissance();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/acteDeces/officier/{nom}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getActeDecesByOfficier(@PathVariable String officier) {
		List<Enregistrement> result = enregistrementService.getActeDecesByOfficier(officier);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/acteNaissance/officier/{nom}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Enregistrement>> getActeNaissanceByOfficier(@PathVariable String officier) {
		List<Enregistrement> result = enregistrementService.getActeNaissanceByOfficier(officier);
		return ResponseEntity.ok().body(result);
	}
}
