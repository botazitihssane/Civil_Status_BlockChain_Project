package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Officier;

public interface OfficierService {
	Officier createOfficier(Officier officier);

	Officier getOfficier(int id);

	List<Officier> getAllOfficiers();

	void deleteOfficier(int id);

	void updateOfficier(Officier officier);

	List<Officier> getOfficierByNomOrPrenom(String nom);

	List<Officier> getOfficierByGrade(String grade);
}
