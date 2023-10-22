package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Arrondissement")
public class Arrondissement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomArrondissement;
	private int population;
	@ManyToOne
	private Prefecture prefecture;
	private String ville;

	public Arrondissement(int id, String nomArrondissement, int population, Prefecture prefecture, String ville) {
		super();
		this.id = id;
		this.nomArrondissement = nomArrondissement;
		this.population = population;
		this.prefecture = prefecture;
		this.ville = ville;
	}

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

	public Prefecture getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(Prefecture prefecture) {
		this.prefecture = prefecture;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}

}