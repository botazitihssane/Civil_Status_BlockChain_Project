package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Registre;

public interface RegistreService {
	Registre createRegistre(Registre registre);

	Registre getRegistre(int id);

	List<Registre> getAllRegistres();

	List<Registre> getRegistresPerType(String type);

	List<Registre> getRegistrePerAnnexe(int idAnnexe);

	void deleteRegistre(int id);

	void updateRegistre(Registre registre);

	List<Registre> searchRegistre(String terme);
}