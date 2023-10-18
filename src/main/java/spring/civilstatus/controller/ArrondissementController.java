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
import spring.civilstatus.models.Arrondissement;
import spring.civilstatus.service.ArrondissementService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArrondissementController {
	@Autowired
	private ArrondissementService arrondissementService;

	@PostMapping(value = "/arrondissement", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Arrondissement> createArrondissement(@Valid @RequestBody Arrondissement arrondissement) {
		Arrondissement result = arrondissementService.createArrondissement(arrondissement);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/arrondissements", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Arrondissement>> getAllArrondissements() {
		List<Arrondissement> result = arrondissementService.getAllArrondissement();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/arrondissement/{arrondissementId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Arrondissement> getArrondisstementById(@PathVariable int arrondissementId) {
		Arrondissement result = arrondissementService.getArrondissement(arrondissementId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/arrondissement/ville/{ville}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Arrondissement>> getArrondisstementPerVille(@PathVariable String ville) {
		List<Arrondissement> result = arrondissementService.geArrondissementPerVille(ville);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/ville", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<String>> getCitiesWithArrondissement() {
		List<String> result = arrondissementService.getCitiesWithArrondissement();
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping(value = "/arrondissement/{arrondissementId}")
	public ResponseEntity<Void> deleteArrondissement(@PathVariable int arrondissementId) {
		arrondissementService.deleteArrondissement(arrondissementId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/arrondissement", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateActeNaissance(@Valid @RequestBody Arrondissement arrondissement) {
		arrondissementService.updateArrondissement(arrondissement);
		return ResponseEntity.noContent().build();
	}
}
