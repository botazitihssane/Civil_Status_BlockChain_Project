package spring.civilstatus.blockchain.domain;

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

	public ActeMariage(int id, String typeEnregistrement, LocalDate dateEnregistrement, String lieuEnregistrement,
			String lieuMariage, LocalDate dateMariage, String epouse, String epoux, String mereEpouse,
			String pereEpouse, String mereEpoux, String pereEpoux) {
		super(id, typeEnregistrement, dateEnregistrement, lieuEnregistrement);
		this.lieuMariage = lieuMariage;
		this.dateMariage = dateMariage;
		Epouse = epouse;
		Epoux = epoux;
		this.mereEpouse = mereEpouse;
		this.pereEpouse = pereEpouse;
		this.mereEpoux = mereEpoux;
		this.pereEpoux = pereEpoux;
	}

}
