package spring.civilstatus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomRegion;
	private int superficie;
	private int population;
	@Column(columnDefinition = "varchar(255) default 'MAROC'")
	private String pays;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Region(int id, String nomRegion, Prefecture chefLieu, int superficie, int population) {
		super();
		this.id = id;
		this.nomRegion = nomRegion;
		this.superficie = superficie;
		this.population = population;
	}

}
