package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Personne;

public interface PersonneService {
	Personne createPersonne(Personne personne);

	List<Personne> getAllPersonne();

	Personne getPersonne(int id);

	void deletePersonne(int id);

	void updatePersonne(Personne personne);

	Personne getPersonneByCIN(String cin);

	List<Personne> getPersonneByTerm(String terme);
}