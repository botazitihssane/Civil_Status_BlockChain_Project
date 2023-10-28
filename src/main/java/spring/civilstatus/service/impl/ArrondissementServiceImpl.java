package spring.civilstatus.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Arrondissement;
import spring.civilstatus.repository.ArrondissementRepository;
import spring.civilstatus.service.ArrondissementService;

@Service
public class ArrondissementServiceImpl implements ArrondissementService {
	private static final Logger logger = LoggerFactory.getLogger(ArrondissementServiceImpl.class);

	@Autowired
	private ArrondissementRepository arrondissementRepository;

	@Override
	public Arrondissement createArrondissement(Arrondissement arrondissement) {
		return arrondissementRepository.save(arrondissement);
	}

	@Override
	public Arrondissement getArrondissement(int id) {
		return arrondissementRepository.getArrondissemtnById(id);
	}

	@Override
	public List<Arrondissement> getAllArrondissement() {
		return arrondissementRepository.findAll();
	}

	@Override
	public List<Arrondissement> geArrondissementPerVille(String ville) {
		logger.info("Fetching arrondissements for city: " + ville);
		List<Arrondissement> arrondissements = arrondissementRepository.getArrondissemetnPerVille(ville);
		logger.info("Retrieved arrondissements: " + arrondissements);
		return arrondissements;
	}

	@Override
	public void deleteArrondissement(int id) {
		arrondissementRepository.deleteById((long) id);
	}

	@Override
	public void updateArrondissement(Arrondissement arrondissement) {
		Arrondissement a = getArrondissement(arrondissement.getId());
		if (a != null) {
			a.setNomArrondissement(arrondissement.getNomArrondissement());
			a.setPopulation(arrondissement.getPopulation());
			arrondissementRepository.save(a);
		}
	}

	@Override
	public List<String> getCitiesWithArrondissement() {
		return arrondissementRepository.getCitiesWithArrondissement();
	}

}
