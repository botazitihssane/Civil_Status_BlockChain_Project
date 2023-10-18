package spring.civilstatus.models;

import java.time.LocalDate;

public class ActeMariage extends Acte {
	private String lieuMariage;
	private LocalDate dateMariage;
	private String Epouse;
	private String Epoux;
	private String mereEpouse;
	private String pereEpouse;
	private String mereEpoux;
	private String pereEpoux;
	private String cinEpouse;
	private String cinEpoux;
	private LocalDate dateNaissanceEpouse;
	private LocalDate dateNaissanceEpoux;
	private String lieuNaissanceEpouse;
	private String lieuNaissanceEpoux;

	public String getLieuMariage() {
		return lieuMariage;
	}

	public void setLieuMariage(String lieuMariage) {
		this.lieuMariage = lieuMariage;
	}

	public LocalDate getDateMariage() {
		return dateMariage;
	}

	public void setDateMariage(LocalDate dateMariage) {
		this.dateMariage = dateMariage;
	}

	public String getEpouse() {
		return Epouse;
	}

	public void setEpouse(String epouse) {
		Epouse = epouse;
	}

	public String getEpoux() {
		return Epoux;
	}

	public void setEpoux(String epoux) {
		Epoux = epoux;
	}

	public String getMereEpouse() {
		return mereEpouse;
	}

	public void setMereEpouse(String mereEpouse) {
		this.mereEpouse = mereEpouse;
	}

	public String getPereEpouse() {
		return pereEpouse;
	}

	public void setPereEpouse(String pereEpouse) {
		this.pereEpouse = pereEpouse;
	}

	public String getMereEpoux() {
		return mereEpoux;
	}

	public void setMereEpoux(String mereEpoux) {
		this.mereEpoux = mereEpoux;
	}

	public String getPereEpoux() {
		return pereEpoux;
	}

	public void setPereEpoux(String pereEpoux) {
		this.pereEpoux = pereEpoux;
	}

	public String getCinEpouse() {
		return cinEpouse;
	}

	public void setCinEpouse(String cinEpouse) {
		this.cinEpouse = cinEpouse;
	}

	public String getCinEpoux() {
		return cinEpoux;
	}

	public void setCinEpoux(String cinEpoux) {
		this.cinEpoux = cinEpoux;
	}

	public LocalDate getDateNaissanceEpouse() {
		return dateNaissanceEpouse;
	}

	public void setDateNaissanceEpouse(LocalDate dateNaissanceEpouse) {
		this.dateNaissanceEpouse = dateNaissanceEpouse;
	}

	public LocalDate getDateNaissanceEpoux() {
		return dateNaissanceEpoux;
	}

	public void setDateNaissanceEpoux(LocalDate dateNaissanceEpoux) {
		this.dateNaissanceEpoux = dateNaissanceEpoux;
	}

	public String getLieuNaissanceEpouse() {
		return lieuNaissanceEpouse;
	}

	public void setLieuNaissanceEpouse(String lieuNaissanceEpouse) {
		this.lieuNaissanceEpouse = lieuNaissanceEpouse;
	}

	public String getLieuNaissanceEpoux() {
		return lieuNaissanceEpoux;
	}

	public void setLieuNaissanceEpoux(String lieuNaissanceEpoux) {
		this.lieuNaissanceEpoux = lieuNaissanceEpoux;
	}

	public ActeMariage(int id, String typeEnregistrement, String officierValidant, String registre,
			LocalDate dateEnregistrement, String lieuEnregistrement, String lieuMariage, LocalDate dateMariage,
			String epouse, String epoux, String mereEpouse, String pereEpouse, String mereEpoux, String pereEpoux,
			String cinEpouse, String cinEpoux, LocalDate dateNaissanceEpouse, LocalDate dateNaissanceEpoux,
			String lieuNaissanceEpouse, String lieuNaissanceEpoux) {
		super(id, typeEnregistrement, officierValidant, registre, dateEnregistrement, lieuEnregistrement);
		this.lieuMariage = lieuMariage;
		this.dateMariage = dateMariage;
		Epouse = epouse;
		Epoux = epoux;
		this.mereEpouse = mereEpouse;
		this.pereEpouse = pereEpouse;
		this.mereEpoux = mereEpoux;
		this.pereEpoux = pereEpoux;
		this.cinEpouse = cinEpouse;
		this.cinEpoux = cinEpoux;
		this.dateNaissanceEpouse = dateNaissanceEpouse;
		this.dateNaissanceEpoux = dateNaissanceEpoux;
		this.lieuNaissanceEpouse = lieuNaissanceEpouse;
		this.lieuNaissanceEpoux = lieuNaissanceEpoux;
	}

}
