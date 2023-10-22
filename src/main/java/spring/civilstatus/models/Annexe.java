package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Annexe")
public class Annexe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomAnnexe;
	@ManyToOne
	private Arrondissement arrondissement;
	@OneToOne
	private Officier officier;

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

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	public Officier getOfficier() {
		return officier;
	}

	public void setOfficier(Officier officier) {
		this.officier = officier;
	}

	public Annexe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Annexe(int id, String nomAnnexe, Arrondissement arrondissement, Officier officier) {
		super();
		this.id = id;
		this.nomAnnexe = nomAnnexe;
		this.arrondissement = arrondissement;
		this.officier = officier;
	}

}