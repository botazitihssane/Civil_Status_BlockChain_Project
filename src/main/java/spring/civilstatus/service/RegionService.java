package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Region;

public interface RegionService {
	Region addRegion(Region region);

	Region getRegion(int id);

	List<Region> getRegions();

	void updateRegion(Region region);

	void deleteRegion(int id);
}
