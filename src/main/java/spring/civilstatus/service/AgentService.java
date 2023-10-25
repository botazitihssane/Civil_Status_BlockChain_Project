package spring.civilstatus.service;

import spring.civilstatus.models.Annexe;

public interface AgentService {
	Annexe findAnnexeByAgentId(Long id);
}
