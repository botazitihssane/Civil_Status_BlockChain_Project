package spring.civilstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.models.Personne;
import spring.civilstatus.repository.PersonneRepository;
import spring.civilstatus.service.PersonneService;


@Service
public class PersonneServiceImpl implements PersonneService {

	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public Personne createPersonne(Personne personne) {
		return personneRepository.save(personne);
	}

	@Override
	public List<Personne> getAllPersonne() {
		return personneRepository.findAll();
	}

	@Override
	public Personne getPersonne(int id) {
		return personneRepository.getPersonneById(id);
	}

	// If a parent (pere or mere) is deleted the fields existing in a child object are set to null
	public void nullifyParents(int id) {
		List<Personne> children = personneRepository.findByPereOrMere(id);

		for (Personne child : children) {
			if (child.getPere() != null && child.getPere().getId() == id) {
				child.setPere(null);
			}
			if (child.getMere() != null && child.getMere().getId() == id) {
				child.setMere(null);
			}
		}
	}

	@Override
	public void deletePersonne(int id) {
		nullifyParents(id);
		personneRepository.deleteById((long) id);
	}

	@Override
	public void updatePersonne(Personne personne) {
		Personne p = getPersonne(personne.getId());
		if (p != null) {
			p.setPrenom(personne.getPrenom());
			p.setNom(personne.getNom());
			p.setAdresse(personne.getAdresse());
			p.setDateNaissance(personne.getDateNaissance());
			p.setEtatCivil(personne.getEtatCivil());
			p.setSexe(personne.getSexe());
			p.setLieuNaissance(personne.getLieuNaissance());
			p.setNationalite(personne.getNationalite());
			p.setMere(personne.getMere());
			p.setPere(personne.getPere());
			personneRepository.save(p);
		}
	}

	@Override
	public Personne getPersonneByCIN(String cin) {
		return personneRepository.getPersonneByCIN(cin);
	}

	@Override
	public List<Personne> getPersonneByTerm(String terme) {
		return personneRepository.getPersonneByTerme(terme);
	}

}