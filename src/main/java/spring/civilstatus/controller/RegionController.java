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
import spring.civilstatus.models.Region;
import spring.civilstatus.service.RegionService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RegionController {
	@Autowired
	private RegionService regionService;

	@PostMapping(value = "/region", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Region> createRegion(@Valid @RequestBody Region region) {
		Region result = regionService.addRegion(region);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping(value = "/regions", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Region>> getAllRegions() {
		List<Region> result = regionService.getRegions();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/region/{regionId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Region> getRegionById(@PathVariable int regionId) {
		Region result = regionService.getRegion(regionId);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping(value = "/region/{regionId}")
	public ResponseEntity<Void> deleteAnnexe(@PathVariable int regionId) {
		regionService.deleteRegion(regionId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/region/", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateRegion(@Valid @RequestBody Region region) {
		regionService.updateRegion(region);
		return ResponseEntity.noContent().build();
	}
}
