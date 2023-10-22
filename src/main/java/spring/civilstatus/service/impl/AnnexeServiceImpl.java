package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Annexe;
import spring.civilstatus.repository.AnnexeRepository;
import spring.civilstatus.service.AnnexeService;

@Service
public class AnnexeServiceImpl implements AnnexeService {
	@Autowired
	private AnnexeRepository annexeRepository;

	@Override
	public Annexe createAnnexe(Annexe annexe) {
		return annexeRepository.save(annexe);
	}

	@Override
	public Annexe getAnnexe(int id) {
		return annexeRepository.getAnnexeById(id);
	}

	@Override
	public List<Annexe> getAllAnnexes() {
		return annexeRepository.findAll();
	}

	@Override
	public List<Annexe> getAnnexesPerArrondissement(int arrondissement) {
		return annexeRepository.getAnnexePerArrondissement(arrondissement);
	}

	@Override
	public void deleteAnnexe(int id) {
		annexeRepository.deleteById((long) id);
	}

	@Override
	public void updateAnnexe(Annexe annexe) {
		Annexe a = getAnnexe(annexe.getId());
		if (a != null) {
			a.setNomAnnexe(annexe.getNomAnnexe());
			a.setArrondissement(annexe.getArrondissement());
			annexeRepository.save(a);
		}
	}

}
