package spring.civilstatus.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActeDeces extends Acte {
	private String nom;
	private String prenom;
	private String causeDeces;
	private LocalDate dateDeces;
	private LocalTime heureDeces;
	private String lieuDeces;
	private String declarant;
	private String relationAvecDefunt;
	private String conjoint;
	private String mere;
	private String pere;
	private String profession;
	private String adresse;
	private LocalDate dateNaissance;
	private String lieuNaissance;

	public String getCauseDeces() {
		return causeDeces;
	}

	public void setCauseDeces(String causeDeces) {
		this.causeDeces = causeDeces;
	}

	public LocalDate getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(LocalDate dateDeces) {
		this.dateDeces = dateDeces;
	}

	public LocalTime getHeureDeces() {
		return heureDeces;
	}

	public void setHeureDeces(LocalTime heureDeces) {
		this.heureDeces = heureDeces;
	}

	public String getLieuDeces() {
		return lieuDeces;
	}

	public void setLieuDeces(String lieuDeces) {
		this.lieuDeces = lieuDeces;
	}

	public String getDeclarant() {
		return declarant;
	}

	public void setDeclarant(String declarant) {
		this.declarant = declarant;
	}

	public String getRelationAvecDefunt() {
		return relationAvecDefunt;
	}

	public void setRelationAvecDefunt(String relationAvecDefunt) {
		this.relationAvecDefunt = relationAvecDefunt;
	}

	public String getConjoint() {
		return conjoint;
	}

	public void setConjoint(String conjoint) {
		this.conjoint = conjoint;
	}

	public String getMere() {
		return mere;
	}

	public void setMere(String mere) {
		this.mere = mere;
	}

	public String getPere() {
		return pere;
	}

	public void setPere(String pere) {
		this.pere = pere;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public ActeDeces(int id, String typeEnregistrement, String officierValidant, String registre,
			LocalDate dateEnregistrement, String lieuEnregistrement, String nom, String prenom, String causeDeces,
			LocalDate dateDeces, LocalTime heureDeces, String lieuDeces, String declarant, String relationAvecDefunt,
			String conjoint, String mere, String pere, String profession, String adresse, LocalDate dateNaissance,
			String lieuNaissance) {
		super(id, typeEnregistrement, officierValidant, registre, dateEnregistrement, lieuEnregistrement);
		this.nom = nom;
		this.prenom = prenom;
		this.causeDeces = causeDeces;
		this.dateDeces = dateDeces;
		this.heureDeces = heureDeces;
		this.lieuDeces = lieuDeces;
		this.declarant = declarant;
		this.relationAvecDefunt = relationAvecDefunt;
		this.conjoint = conjoint;
		this.mere = mere;
		this.pere = pere;
		this.profession = profession;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}

	

}
