package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Enregistrement;
import spring.civilstatus.repository.EnregistrementRepository;
import spring.civilstatus.service.EnregistrementService;

@Service
public class EnregistrementServiceImpl implements EnregistrementService {

	@Autowired
	EnregistrementRepository enregistrementRepository;

	@Override
	public Enregistrement addEnregistrement(Enregistrement e) {
		return enregistrementRepository.save(e);
	}

	@Override
	public List<Enregistrement> findAll() {
		return enregistrementRepository.findAll();
	}

	@Override
	public List<Enregistrement> getEnregistrementByAgent(String agent) {
		return enregistrementRepository.getEnregistrementByOfficierNom(agent);
	}

	@Override
	public Enregistrement getById(int id) {
		return enregistrementRepository.getById(id);
	}

	@Override
	public List<Enregistrement> getEnregistrementByRegistre(int registre) {
		return enregistrementRepository.getEnregistrementByRegistre(registre);
	}

	@Override
	public List<Enregistrement> getActeDeces() {
		return enregistrementRepository.getActeDeces();
	}

	@Override
	public List<Enregistrement> getActeNaissance() {
		return enregistrementRepository.getActeNaissance();
	}

	@Override
	public List<Enregistrement> getActeDecesByOfficier(String nom) {
		return enregistrementRepository.getEnregistrementByOfficierNomAndActeDeces(nom);
	}

	@Override
	public List<Enregistrement> getActeNaissanceByOfficier(String nom) {
		return enregistrementRepository.getEnregistrementByOfficierNomAndActeNaissance(nom);
	}

}
