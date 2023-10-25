package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Prefecture;
import spring.civilstatus.repository.PrefectureRepository;
import spring.civilstatus.service.PrefectureService;
@Service
public class PrefectureServiceImpl implements PrefectureService {

	@Autowired
	private PrefectureRepository prefectureRepository;

	@Override
	public Prefecture addPrefecture(Prefecture prefecture) {
		return prefectureRepository.save(prefecture);
	}

	@Override
	public Prefecture getPrefecture(int id) {
		return prefectureRepository.getPrefectureById(id);
	}

	@Override
	public List<Prefecture> getPrefectures() {
		return prefectureRepository.findAll();
	}

	@Override
	public void updatePrefecture(Prefecture prefecture) {
		Prefecture p = getPrefecture(prefecture.getId());
		if (p != null) {
			p.setNomPrefecture(prefecture.getNomPrefecture());
			p.setPopulation(prefecture.getPopulation());
			p.setRegion(prefecture.getRegion());
			prefectureRepository.save(p);
		}

	}

	@Override
	public void deletePrefecture(int id) {
		prefectureRepository.deleteById((long) id);
	}

	@Override
	public List<Prefecture> getPrefectureByRegion(int region) {
		return prefectureRepository.getPrefectureByRegion(region);
	}

}
