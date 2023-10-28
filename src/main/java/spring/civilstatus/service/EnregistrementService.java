package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Enregistrement;

public interface EnregistrementService {
	Enregistrement addEnregistrement(Enregistrement e);

	List<Enregistrement> findAll();

	List<Enregistrement> getEnregistrementByAgent(String agent);

	Enregistrement getById(int id);

	List<Enregistrement> getEnregistrementByRegistre(int registre);
}
