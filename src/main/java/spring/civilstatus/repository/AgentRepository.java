package spring.civilstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Agent;
import spring.civilstatus.models.Annexe;

public interface AgentRepository extends JpaRepository<Agent, Long> {

	@Query("SELECT o.annexe FROM Agent o WHERE o.id = :id")
	Annexe findAnnexeByAgentId(@Param("id") Long id);
}
