package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Officier")
public class Officier extends User {
	private String prenom;
	private String nom;
	private String grade;
	@OneToOne
	private Annexe annexe;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Officier(String prenom, String nom, String cin, String grade) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.grade = grade;
	}

	public Officier() {
		super();
		// TODO Auto-generated constructor stub
	}

}