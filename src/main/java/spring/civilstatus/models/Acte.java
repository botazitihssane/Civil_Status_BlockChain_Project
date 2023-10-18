package spring.civilstatus.models;

import java.time.LocalDate;

public abstract class Acte {
	private static int lastGeneratedId = 0;
	private int id;
	private String typeEnregistrement;
	private String officierValidant;
	private String registre;
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

	public String getOfficierValidant() {
		return officierValidant;
	}

	public void setOfficierValidant(String officierValidant) {
		this.officierValidant = officierValidant;
	}

	public String getRegistre() {
		return registre;
	}

	public void setRegistre(String registre) {
		this.registre = registre;
	}

	public Acte(int id, String typeEnregistrement, String officierValidant, String registre,
			LocalDate dateEnregistrement, String lieuEnregistrement) {
		super();
		this.id = generateUniqueId();
		this.typeEnregistrement = typeEnregistrement;
		this.officierValidant = officierValidant;
		this.registre = registre;
		this.dateEnregistrement = dateEnregistrement;
		this.lieuEnregistrement = lieuEnregistrement;
	}

	private synchronized int generateUniqueId() {
		lastGeneratedId++;
		return lastGeneratedId;
	}
}
