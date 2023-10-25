package spring.civilstatus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Annexe;
import spring.civilstatus.repository.AgentRepository;
import spring.civilstatus.service.AgentService;
@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public Annexe findAnnexeByAgentId(Long id) {
		return agentRepository.findAnnexeByAgentId(id);
		
	}

}
