package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Enregistrement;

public interface EnregistrementRepository extends JpaRepository<Enregistrement, Long> {

	@Query("Select e from Enregistrement e where e.id=:id")
	Enregistrement getById(@Param("id") int id);

	@Query("Select e from Enregistrement e where e.registre.id=:registre")
	List<Enregistrement> getEnregistrementByRegistre(@Param("registre") int registre);

	@Query("SELECT e FROM Enregistrement e JOIN e.officier a WHERE a.nom = :nom")
    List<Enregistrement> getEnregistrementByOfficierNom(@Param("nom") String nom);
}
