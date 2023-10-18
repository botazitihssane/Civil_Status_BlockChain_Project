 package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Registre;
import spring.civilstatus.repository.RegistreRepository;
import spring.civilstatus.service.RegistreService;

@Service
public class RegisteServiceImpl implements RegistreService {

	@Autowired
	private RegistreRepository registreRepository;

	@Override
	public Registre createRegistre(Registre registre) {
		return registreRepository.save(registre);
	}

	@Override
	public Registre getRegistre(int id) {
		return registreRepository.getRegistreById(id);
	}

	@Override
	public List<Registre> getAllRegistres() {
		return registreRepository.findAll();
	}

	@Override
	public List<Registre> getRegistresPerType(String type) {
		return registreRepository.getRegistreByType(type);
	}

	@Override
	public List<Registre> getRegistrePerAnnexe(int idAnnexe) {
		return registreRepository.getRegistreByAnnexe(idAnnexe);
	}

	@Override
	public void deleteRegistre(int id) {
		registreRepository.deleteById((long) id);
	}

	@Override
	public void updateRegistre(Registre registre) {
		Registre r = getRegistre(registre.getId());
		if (r != null) {
			r.setNomRegistre(registre.getNomRegistre());
			r.setTypeRegistre(registre.getTypeRegistre());
			r.setAnnexe(registre.getAnnexe());
			registreRepository.save(r);
		}
	}

	@Override
	public List<Registre> searchRegistre(String terme) {
		return registreRepository.getRegistreByTerm(terme);
	}

}
