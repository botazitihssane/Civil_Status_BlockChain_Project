package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Region;
import spring.civilstatus.repository.RegionRepository;
import spring.civilstatus.service.RegionService;
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository;

	@Override
	public Region addRegion(Region region) {
		return regionRepository.save(region);
	}

	@Override
	public Region getRegion(int id) {
		return regionRepository.getRegionById(id);
	}

	@Override
	public List<Region> getRegions() {
		return regionRepository.findAll();
	}

	@Override
	public void updateRegion(Region region) {
		Region r = getRegion(region.getId());
		if(r != null ) {
			r.setNomRegion(region.getNomRegion());
			r.setPopulation(r.getPopulation());
			r.setSuperficie(region.getSuperficie());
			regionRepository.save(r);
		}
	}

	@Override
	public void deleteRegion(int id) {
		regionRepository.deleteById((long) id);
	}

}
