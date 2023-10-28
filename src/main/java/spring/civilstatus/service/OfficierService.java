package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Annexe;
import spring.civilstatus.models.Officier;

public interface OfficierService {
	Annexe findAnnexeByAgentId(Long id);

	Officier createOfficier(Officier officier);

	Officier getOfficier(Long id);

	List<Officier> getAllOfficiers();

	void deleteOfficier(int id);

	void updateOfficier(Officier officier);

	List<Officier> getOfficierByNomOrPrenom(String nom);
}
