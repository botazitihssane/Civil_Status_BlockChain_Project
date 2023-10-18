package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Officier;
import spring.civilstatus.repository.OfficierRepository;
import spring.civilstatus.service.OfficierService;

@Service
public class OfficierServiceImpl implements OfficierService {
	@Autowired
	private OfficierRepository officierRepository;

	@Override
	public Officier createOfficier(Officier officier) {
		return officierRepository.save(officier);
	}

	@Override
	public Officier getOfficier(int id) {
		return officierRepository.getOfficierById(id);
	}

	@Override
	public List<Officier> getAllOfficiers() {
		return officierRepository.findAll();
	}

	@Override
	public void deleteOfficier(int id) {
		officierRepository.deleteById((long) id);
	}

	@Override
	public void updateOfficier(Officier officier) {
		Officier o = getOfficier(officier.getId());
		if (o != null) {
			o.setNom(officier.getNom());
			o.setPrenom(officier.getPrenom());
			o.setCin(officier.getCin());
			o.setEmail(officier.getEmail());
			o.setTelephone(officier.getTelephone());
			o.setGrade(officier.getGrade());
			officierRepository.save(o);
		}
	}

	@Override
	public List<Officier> getOfficierByNomOrPrenom(String nom) {
		return officierRepository.getOfficiersByNomOrPrenomOrGrade(nom);
	}

	@Override
	public List<Officier> getOfficierByGrade(String grade) {
		return officierRepository.getOfficiersByGrade(grade);
	}

}
