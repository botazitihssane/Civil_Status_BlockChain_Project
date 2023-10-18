package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Annexe;

public interface AnnexeService {
	Annexe createAnnexe(Annexe annexe);

	Annexe getAnnexe(int id);

	List<Annexe> getAllAnnexes();

	List<Annexe> getAnnexesPerArrondissement(int arrondissement);

	void deleteAnnexe(int id);

	void updateAnnexe(Annexe annexe);
}