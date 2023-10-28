package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agent")
public class Officier extends User {

	private String prenom;
	private String nom;
	@ManyToOne
	private Annexe annexe;

	public Officier(String prenom, String nom, Annexe annexe) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.annexe = annexe;
	}

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

	public Annexe getAnnexe() {
		return annexe;
	}

	public void setAnnexe(Annexe annexe) {
		this.annexe = annexe;
	}

	public Officier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Officier(String username, String email, String password, Annexe annexe) {
		super(username, email, password);
		this.annexe = annexe;
	}

}
