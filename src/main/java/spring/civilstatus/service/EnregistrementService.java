package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Enregistrement;

public interface EnregistrementService {
	Enregistrement addEnregistrement(Enregistrement e);

	List<Enregistrement> findAll();

	List<Enregistrement> getEnregistrementByAgent(String agent);

	Enregistrement getById(int id);

	List<Enregistrement> getEnregistrementByRegistre(int registre);

	List<Enregistrement> getActeDeces();

	List<Enregistrement> getActeNaissance();

	List<Enregistrement> getActeDecesByOfficier(String nom);

	List<Enregistrement> getActeNaissanceByOfficier(String nom);
}
