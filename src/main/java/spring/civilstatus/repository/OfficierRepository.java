package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Officier;
import spring.civilstatus.models.Annexe;

public interface OfficierRepository extends JpaRepository<Officier, Long> {

	@Query("SELECT o.annexe FROM Officier o WHERE o.id = :id")
	Annexe findAnnexeByAgentId(@Param("id") Long id);

	@Query("Select o from Officier o where o.id=:id")
	Officier getOfficierById(@Param("id") Long id);

	@Query("SELECT o FROM Officier o WHERE LOWER(o.nom) LIKE CONCAT('%', LOWER(:terme), '%') OR LOWER(o.prenom) LIKE CONCAT('%', LOWER(:terme), '%')")
	List<Officier> getOfficiersByNomOrPrenom(@Param("terme") String terme);
}
