package spring.civilstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Prefecture;

public interface PrefectureRepository extends JpaRepository<Prefecture, Long> {
	@Query("Select a from Prefecture a where a.id=:id")
	Prefecture getPrefectureById(@Param("id") int id);
	
	@Query("Select p from Prefecture p where p.region.id=:region")
	List<Prefecture> getPrefectureByRegion(@Param("region") int region);
}
