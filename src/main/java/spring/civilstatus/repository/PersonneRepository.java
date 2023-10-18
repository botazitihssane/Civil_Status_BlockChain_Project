package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
	@Query("Select p from Personne p where p.id=:id")
	Personne getPersonneById(@Param("id") int id);

	@Query("Select p from Personne p where mere.id=:id or pere.id=:id")
	List<Personne> findByPereOrMere(@Param("id") int id);

	@Query("Select p from Personne p where p.numeroIdentification=:cin")
	Personne getPersonneByCIN(@Param("cin") String cin);

	@Query("Select p from Personne p where LOWER(p.nom) LIKE CONCAT('%', LOWER(:terme), '%') OR LOWER(p.prenom) LIKE CONCAT('%', LOWER(:terme), '%')")
	List<Personne> getPersonneByTerme(@Param("terme") String terme);
}