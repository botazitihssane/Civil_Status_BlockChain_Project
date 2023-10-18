package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Registre;

public interface RegistreRepository extends JpaRepository<Registre, Long> {
	@Query("Select r from Registre r where r.id=:id")
	Registre getRegistreById(@Param("id") int id);

	@Query("Select r from Registre r where r.typeRegistre=:type")
	List<Registre> getRegistreByType(@Param("type") String type);

	@Query("Select r from Registre r where r.annexe.id=:id")
	List<Registre> getRegistreByAnnexe(@Param("id") int id);

	@Query("SELECT o FROM Registre o LEFT JOIN o.annexe a WHERE LOWER(o.nomRegistre) LIKE CONCAT('%', LOWER(:terme), '%') OR LOWER(o.typeRegistre) LIKE CONCAT('%', LOWER(:terme), '%') OR LOWER(a.nomAnnexe) LIKE CONCAT('%', LOWER(:terme), '%')")
	List<Registre> getRegistreByTerm(@Param("terme") String terme);

}