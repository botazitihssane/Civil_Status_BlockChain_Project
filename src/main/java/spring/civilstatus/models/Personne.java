package spring.civilstatus.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Personne")
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String sexe;
	private String numeroIdentification;
	private LocalDate dateNaissance;
	private String lieuNaissance;
	private String nationalite;
	private String adresse;
	private String profession;
	private String etatCivil;
	@ManyToOne
	private Personne pere;
	@ManyToOne
	private Personne mere;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNumeroIdentification() {
		return numeroIdentification;
	}

	public void setNumeroIdentification(String numeroIdentification) {
		this.numeroIdentification = numeroIdentification;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}

	public Personne getPere() {
		return pere;
	}

	public void setPere(Personne pere) {
		this.pere = pere;
	}

	public Personne getMere() {
		return mere;
	}

	public void setMere(Personne mere) {
		this.mere = mere;
	}

	public Personne(int id, String nom, String prenom, String sexe, String numeroIdentification,
			LocalDate dateNaissance, String lieuNaissance, String nationalite, String adresse, String profession,
			String etatCivil, Personne pere, Personne mere) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.numeroIdentification = numeroIdentification;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.profession = profession;
		this.etatCivil = etatCivil;
		this.pere = pere;
		this.mere = mere;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

}