package spring.civilstatus.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Arrondissement")
public class Arrondissement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomArrondissement;
	private String ville;
	private String pays;
	private int codePostal;
	private int population;
	private float superficie;
	private String adresseArrondissement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomArrondissement() {
		return nomArrondissement;
	}

	public void setNomArrondissement(String nomArrondissement) {
		this.nomArrondissement = nomArrondissement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public String getAdresseArrondissement() {
		return adresseArrondissement;
	}

	public void setAdresseArrondissement(String adresseArrondissement) {
		this.adresseArrondissement = adresseArrondissement;
	}

	public Arrondissement(int id, String nomArrondissement, String ville, String pays, int codePostal, int population,
			float superficie, String adresseArrondissement, List<String> quartiers) {
		super();
		this.id = id;
		this.nomArrondissement = nomArrondissement;
		this.ville = ville;
		this.pays = pays;
		this.codePostal = codePostal;
		this.population = population;
		this.superficie = superficie;
		this.adresseArrondissement = adresseArrondissement;
	}

	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}

}