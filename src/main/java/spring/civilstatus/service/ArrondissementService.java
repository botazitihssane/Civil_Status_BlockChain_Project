package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Arrondissement;

public interface ArrondissementService {
	Arrondissement createArrondissement(Arrondissement Arrondissement);

	Arrondissement getArrondissement(int id);

	List<Arrondissement> getAllArrondissement();

	List<Arrondissement> geArrondissementPerVille(String ville);

	void deleteArrondissement(int id);

	void updateArrondissement(Arrondissement arrondissement);

	List<String> getCitiesWithArrondissement();
}