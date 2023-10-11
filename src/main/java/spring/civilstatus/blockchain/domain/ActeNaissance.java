package spring.civilstatus.blockchain.domain;

import java.time.LocalDate;

public class ActeNaissance extends Acte {
	private String nouveauNe;
	private String typeNaissance;
	private String declarant;
	private String relationAvecNouveauNe;
	public String getNouveauNe() {
		return nouveauNe;
	}
	public void setNouveauNe(String nouveauNe) {
		this.nouveauNe = nouveauNe;
	}
	public String getTypeNaissance() {
		return typeNaissance;
	}
	public void setTypeNaissance(String typeNaissance) {
		this.typeNaissance = typeNaissance;
	}
	public String getDeclarant() {
		return declarant;
	}
	public void setDeclarant(String declarant) {
		this.declarant = declarant;
	}
	public String getRelationAvecNouveauNe() {
		return relationAvecNouveauNe;
	}
	public void setRelationAvecNouveauNe(String relationAvecNouveauNe) {
		this.relationAvecNouveauNe = relationAvecNouveauNe;
	}
	public ActeNaissance(int id, String typeEnregistrement, LocalDate dateEnregistrement, String lieuEnregistrement,
			String nouveauNe, String typeNaissance, String declarant, String relationAvecNouveauNe) {
		super(id, typeEnregistrement, dateEnregistrement, lieuEnregistrement);
		this.nouveauNe = nouveauNe;
		this.typeNaissance = typeNaissance;
		this.declarant = declarant;
		this.relationAvecNouveauNe = relationAvecNouveauNe;
	}
	
	
	
}
