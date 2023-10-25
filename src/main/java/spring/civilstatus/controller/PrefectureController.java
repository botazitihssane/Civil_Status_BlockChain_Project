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
import spring.civilstatus.models.Prefecture;
import spring.civilstatus.service.PrefectureService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PrefectureController {
	@Autowired
	private PrefectureService prefectureService;
	
	@PostMapping(value = "/prefecture", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Prefecture> createPrefecture(@Valid @RequestBody Prefecture prefecture) {
		Prefecture result = prefectureService.addPrefecture(prefecture);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/prefectures", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Prefecture>> getAllPrefectures() {
		List<Prefecture> result = prefectureService.getPrefectures();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/prefecture/{prefectureId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Prefecture> getPrefectureById(@PathVariable int prefectureId) {
		Prefecture result = prefectureService.getPrefecture(prefectureId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/prefecture/region/{regionId}", produces = { "application/json",
			"application/xml" })
	public ResponseEntity<List<Prefecture>> getPrefecturesPerArrondissement(@PathVariable int regionId) {
		List<Prefecture> result = prefectureService.getPrefectureByRegion(regionId);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping(value = "/prefecture/{prefectureId}")
	public ResponseEntity<Void> deletePrefecture(@PathVariable int prefectureId) {
		prefectureService.deletePrefecture(prefectureId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/prefecture/", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updatePrefecture(@Valid @RequestBody Prefecture prefecture) {
		prefectureService.updatePrefecture(prefecture);
		return ResponseEntity.noContent().build();
	}
}
