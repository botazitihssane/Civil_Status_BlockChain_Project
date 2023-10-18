package spring.civilstatus.models;

import java.time.LocalDate;

public class ActeNaissance extends Acte {
	private String nom;
	private String prenom;
	private String typeNaissance;
	private String declarant;
	private String relationAvecNouveauNe;
	private String pere;
	private String mere;
	private String nationalite;
	private String sexe;
	private LocalDate dateNaissance;
	private String lieuNaissance;

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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	public String getTypeNaissance() {
		return typeNaissance;
	}

	public void setTypeNaissance(String typeNaissance) {
		this.typeNaissance = typeNaissance;
	}

	public String getRelationAvecNouveauNe() {
		return relationAvecNouveauNe;
	}

	public void setRelationAvecNouveauNe(String relationAvecNouveauNe) {
		this.relationAvecNouveauNe = relationAvecNouveauNe;
	}

	public String getDeclarant() {
		return declarant;
	}

	public void setDeclarant(String declarant) {
		this.declarant = declarant;
	}

	public String getPere() {
		return pere;
	}

	public void setPere(String pere) {
		this.pere = pere;
	}

	public String getMere() {
		return mere;
	}

	public void setMere(String mere) {
		this.mere = mere;
	}

	public ActeNaissance(int id, String typeEnregistrement, String officierValidant, String registre,
			LocalDate dateEnregistrement, String lieuEnregistrement, String nom, String prenom, String typeNaissance,
			String declarant, String relationAvecNouveauNe, String pere, String mere, String nationalite, String sexe,
			LocalDate dateNaissance, String lieuNaissance) {
		super(id, typeEnregistrement, officierValidant, registre, dateEnregistrement, lieuEnregistrement);
		this.nom = nom;
		this.prenom = prenom;
		this.typeNaissance = typeNaissance;
		this.declarant = declarant;
		this.relationAvecNouveauNe = relationAvecNouveauNe;
		this.pere = pere;
		this.mere = mere;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}

}
