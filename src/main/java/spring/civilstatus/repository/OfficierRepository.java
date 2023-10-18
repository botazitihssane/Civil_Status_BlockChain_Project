package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Officier;

public interface OfficierRepository extends JpaRepository<Officier, Long> {
	@Query("Select o from Officier o where o.id=:id")
	Officier getOfficierById(@Param("id") int id);

	@Query("SELECT o FROM Officier o WHERE LOWER(o.nom) LIKE CONCAT('%', LOWER(:terme), '%') OR LOWER(o.prenom) LIKE CONCAT('%', LOWER(:terme), '%') OR LOWER(o.grade) LIKE CONCAT('%', LOWER(:terme), '%')")
	List<Officier> getOfficiersByNomOrPrenomOrGrade(@Param("terme") String terme);

	@Query("Select o from Officier o where o.grade=:grade")
	List<Officier> getOfficiersByGrade(@Param("grade") String grade);
}