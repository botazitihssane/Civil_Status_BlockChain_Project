package spring.civilstatus.blockchain.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActeDeces extends Acte {
	private String defunt;
	private String causeDeces;
	private LocalDate dateDeces;
	private LocalTime heureDeces;
	private String lieuDeces;
	private String declarant;
	private String relationAvecDefunt;
	private String conjoint;

	public String getDefunt() {
		return defunt;
	}

	public void setDefunt(String defunt) {
		this.defunt = defunt;
	}

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

	public ActeDeces(int id, String typeEnregistrement, LocalDate dateEnregistrement, String lieuEnregistrement,
			String defunt, String causeDeces, LocalDate dateDeces, LocalTime heureDeces, String lieuDeces,
			String declarant, String relationAvecDefunt, String conjoint) {
		super(id, typeEnregistrement, dateEnregistrement, lieuEnregistrement);
		this.defunt = defunt;
		this.causeDeces = causeDeces;
		this.dateDeces = dateDeces;
		this.heureDeces = heureDeces;
		this.lieuDeces = lieuDeces;
		this.declarant = declarant;
		this.relationAvecDefunt = relationAvecDefunt;
		this.conjoint = conjoint;
	}

}
