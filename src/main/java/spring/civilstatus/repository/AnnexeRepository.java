package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Annexe;

public interface AnnexeRepository extends JpaRepository<Annexe, Long> {
	@Query("Select a from Annexe a where a.arrondissement.id=:arrondissement")
	List<Annexe> getAnnexePerArrondissement(@Param("arrondissement") int arrondissement);

	@Query("Select a from Annexe a where a.id=:id")
	Annexe getAnnexeById(@Param("id") int id);
}