package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Annexe")
public class Annexe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomAnnexe;
	private String adresseAnnexe;
	@ManyToOne
	private Arrondissement arrondissement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAnnexe() {
		return nomAnnexe;
	}

	public void setNomAnnexe(String nomAnnexe) {
		this.nomAnnexe = nomAnnexe;
	}

	public String getAdresseAnnexe() {
		return adresseAnnexe;
	}

	public void setAdresseAnnexe(String adresseAnnexe) {
		this.adresseAnnexe = adresseAnnexe;
	}

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	public Annexe(int id, String nomAnnexe, String adresseAnnexe, Arrondissement arrondissement) {
		super();
		this.id = id;
		this.nomAnnexe = nomAnnexe;
		this.adresseAnnexe = adresseAnnexe;
		this.arrondissement = arrondissement;
	}

	public Annexe() {
		super();
		// TODO Auto-generated constructor stub
	}

}