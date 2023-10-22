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
import spring.civilstatus.models.Officier;
import spring.civilstatus.service.OfficierService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class OfficierController {
	@Autowired
	private OfficierService officierService;

	@PostMapping(value = "/officier", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Officier> createOfficier(@Valid @RequestBody Officier officier) {
		Officier result = officierService.createOfficier(officier);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/officiers", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Officier>> getAllOfficiers() {
		List<Officier> result = officierService.getAllOfficiers();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/officier/{officierId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Officier> getOfficierById(@PathVariable Long officierId) {
		Officier result = officierService.getOfficier(officierId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/officier/nom/{nom}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Officier>> getOfficierByNomOrPrenom(@PathVariable String nom) {
		List<Officier> result = officierService.getOfficierByNomOrPrenom(nom);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/officier/grade/{grade}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Officier>> getOfficierByGrade(@PathVariable String grade) {
		List<Officier> result = officierService.getOfficierByGrade(grade);
		return ResponseEntity.ok().body(result);
	}

	@Operation(summary = "Delete an Officier")
	@DeleteMapping(value = "/Officier/{officierId}")
	public ResponseEntity<Void> deleteOfficier(@PathVariable int officierId) {
		try {
			officierService.deleteOfficier(officierId);
			return ResponseEntity.noContent().build();
		} catch (DataIntegrityViolationException ex) {
			throw ex;
		}
	}

	@PutMapping(value = "/officier", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateOfficier(@Valid @RequestBody Officier officier) {
		officierService.updateOfficier(officier);
		return ResponseEntity.noContent().build();
	}
}
