package spring.civilstatus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring.civilstatus.models.Annexe;
import spring.civilstatus.service.AgentService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AgentController {

	@Autowired
	private AgentService agentService;

	@GetMapping(value = "/agent/annexe/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Annexe> getAnnexeAgent(@PathVariable Long id) {
		Annexe result = agentService.findAnnexeByAgentId(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
