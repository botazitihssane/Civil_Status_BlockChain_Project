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
import spring.civilstatus.models.Personne;
import spring.civilstatus.service.PersonneService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PersonneController {
	@Autowired
	private PersonneService personneService;

	@PostMapping(value = "/personne", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Personne> createPersonne(@Valid @RequestBody Personne personne) {
		Personne result = personneService.createPersonne(personne);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/personnes", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Personne>> getAllPersonnes() {
		List<Personne> result = personneService.getAllPersonne();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/personne/{personneId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Personne> getPersonneById(@PathVariable int personneId) {
		Personne result = personneService.getPersonne(personneId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/personne/cin/{cin}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Personne> getPersonneById(@PathVariable String cin) {
		Personne result = personneService.getPersonneByCIN(cin);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/personne/terme/{terme}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Personne>> getPersonneByTerm(@PathVariable String terme) {
		List<Personne> result = personneService.getPersonneByTerm(terme);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping(value = "/personne/{personneId}")
	public ResponseEntity<Void> deletePersonne(@PathVariable int personneId) {
		personneService.deletePersonne(personneId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/personne", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updatePersonne(@Valid @RequestBody Personne personne) {
		personneService.updatePersonne(personne);
		return ResponseEntity.noContent().build();
	}
}