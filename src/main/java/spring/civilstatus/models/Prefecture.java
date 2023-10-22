package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prefecture")
public class Prefecture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int population;
	private String nomPrefecture;
	@ManyToOne
	private Region region;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getNomPrefecture() {
		return nomPrefecture;
	}

	public void setNomPrefecture(String nomPrefecture) {
		this.nomPrefecture = nomPrefecture;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Prefecture(int id, int population, String nomPrefecture, Region region) {
		super();
		this.id = id;
		this.population = population;
		this.nomPrefecture = nomPrefecture;
		this.region = region;
	}

}
