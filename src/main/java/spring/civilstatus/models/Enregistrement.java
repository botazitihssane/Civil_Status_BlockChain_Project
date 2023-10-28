package spring.civilstatus.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enregistrement")
public class Enregistrement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String typeEnregistrement;
	private LocalDate dateEnregistrement;
	@ManyToOne
	private Registre registre;
	@ManyToOne
	private Officier officier;
	@ManyToOne
	private Personne personne;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeEnregistrement() {
		return typeEnregistrement;
	}

	public void setTypeEnregistrement(String typeEnregistrement) {
		this.typeEnregistrement = typeEnregistrement;
	}

	public LocalDate getDateEnregistrement() {
		return dateEnregistrement;
	}

	public void setDateEnregistrement(LocalDate dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}

	public Registre getRegistre() {
		return registre;
	}

	public void setRegistre(Registre registre) {
		this.registre = registre;
	}

	public Enregistrement(int id, String typeEnregistrement, LocalDate dateEnregistrement, Registre registre,
			Officier officier, Personne personne) {
		super();
		this.id = id;
		this.typeEnregistrement = typeEnregistrement;
		this.dateEnregistrement = dateEnregistrement;
		this.registre = registre;
		this.officier = officier;
		this.personne = personne;
	}

	public Officier getOfficier() {
		return officier;
	}

	public void setOfficier(Officier officier) {
		this.officier = officier;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Enregistrement() {
		super();
	}

}
