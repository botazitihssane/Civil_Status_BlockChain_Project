package spring.civilstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring.civilstatus.models.Annexe;
import spring.civilstatus.service.AnnexeService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AnnexeController {
	@Autowired
	private AnnexeService annexeService;

	@PostMapping(value = "/annexe", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Annexe> createAnnexe(@Valid @RequestBody Annexe annexe) {
		Annexe result = annexeService.createAnnexe(annexe);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/annexes", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Annexe>> getAllAnnexes() {
		List<Annexe> result = annexeService.getAllAnnexes();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/annexe/{annexeId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Annexe> getAnnexeById(@PathVariable int annexeId) {
		Annexe result = annexeService.getAnnexe(annexeId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/annexe/arrondissement/{arrondissementId}", produces = { "application/json",
			"application/xml" })
	public ResponseEntity<List<Annexe>> getAnnexesPerArrondissement(@PathVariable int arrondissementId) {
		List<Annexe> result = annexeService.getAnnexesPerArrondissement(arrondissementId);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping(value = "/annexe/{annexeId}")
	public ResponseEntity<Void> deleteAnnexe(@PathVariable int annexeId) {
		annexeService.deleteAnnexe(annexeId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/annexe/", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateAnnexe(@Valid @RequestBody Annexe annexe) {
		annexeService.updateAnnexe(annexe);
		return ResponseEntity.noContent().build();
	}
}