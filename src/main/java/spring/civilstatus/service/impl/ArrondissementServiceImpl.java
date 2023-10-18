package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Arrondissement;
import spring.civilstatus.repository.ArrondissementRepository;
import spring.civilstatus.service.ArrondissementService;

@Service
public class ArrondissementServiceImpl implements ArrondissementService {
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
		return arrondissementRepository.getArrondissemetnPerVille(ville);
	}

	@Override
	public void deleteArrondissement(int id) {
		arrondissementRepository.deleteById((long) id);
	}

	@Override
	public void updateArrondissement(Arrondissement arrondissement) {
		Arrondissement a = getArrondissement(arrondissement.getId());
		if (a != null) {
			a.setAdresseArrondissement(arrondissement.getAdresseArrondissement());
			a.setCodePostal(arrondissement.getCodePostal());
			a.setNomArrondissement(arrondissement.getNomArrondissement());
			a.setPays(arrondissement.getPays());
			a.setPopulation(arrondissement.getPopulation());
			a.setSuperficie(arrondissement.getSuperficie());
			a.setVille(arrondissement.getVille());
			arrondissementRepository.save(a);
		}
	}

	@Override
	public List<String> getCitiesWithArrondissement() {
		return arrondissementRepository.getCitiesWithArrondissement();
	}

}
