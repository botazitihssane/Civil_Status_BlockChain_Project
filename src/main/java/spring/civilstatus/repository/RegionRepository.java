package spring.civilstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.civilstatus.models.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	@Query("Select r from Region r where r.id=:id")
	Region getRegionById(@Param("id") int id);
}
