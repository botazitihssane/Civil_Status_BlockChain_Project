package spring.civilstatus.blockchain.domain;

import java.time.LocalDate;

public abstract class Acte {
	private int id;
	private String typeEnregistrement;
	private LocalDate dateEnregistrement;
	private String lieuEnregistrement;
	
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
	public String getLieuEnregistrement() {
		return lieuEnregistrement;
	}
	public void setLieuEnregistrement(String lieuEnregistrement) {
		this.lieuEnregistrement = lieuEnregistrement;
	}
	public Acte(int id, String typeEnregistrement, LocalDate dateEnregistrement, String lieuEnregistrement) {
		super();
		this.id = id;
		this.typeEnregistrement = typeEnregistrement;
		this.dateEnregistrement = dateEnregistrement;
		this.lieuEnregistrement = lieuEnregistrement;
	}
	
	
}
