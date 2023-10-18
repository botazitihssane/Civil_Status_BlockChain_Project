package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Arrondissement;

public interface ArrondissementRepository extends JpaRepository<Arrondissement, Long> {
	@Query("Select a from Arrondissement a where a.ville=:ville")
	List<Arrondissement> getArrondissemetnPerVille(@Param("ville") String ville);

	@Query("Select a from Arrondissement a where a.id=:id")
	Arrondissement getArrondissemtnById(@Param("id") int id);

	@Query("SELECT DISTINCT a.ville FROM Arrondissement a")
	List<String> getCitiesWithArrondissement();
}