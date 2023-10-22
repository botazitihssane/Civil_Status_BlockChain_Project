package spring.civilstatus.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enregistrement")
public class Enregistrement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String typeEnregistrement;
	private LocalDate dateEnregistrement;
	@ManyToOne
	private Registre registre;
	private String lieuEnregistrement;
	@ManyToOne
	private Officier officierValidant;
	@ManyToOne
	private Agent agent;
	@ManyToOne
	private Personne personne;
	private boolean status;
	private String hash;

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

	public Officier getOfficierValidant() {
		return officierValidant;
	}

	public void setOfficierValidant(Officier officierValidant) {
		this.officierValidant = officierValidant;
	}

	public Registre getRegistre() {
		return registre;
	}

	public void setRegistre(Registre registre) {
		this.registre = registre;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Enregistrement(int id, String typeEnregistrement, LocalDate dateEnregistrement, Registre registre,
			String lieuEnregistrement, Officier officierValidant, Agent agent, Personne personne, boolean status,
			String hash) {
		super();
		this.id = id;
		this.typeEnregistrement = typeEnregistrement;
		this.dateEnregistrement = dateEnregistrement;
		this.registre = registre;
		this.lieuEnregistrement = lieuEnregistrement;
		this.officierValidant = officierValidant;
		this.agent = agent;
		this.personne = personne;
		this.status = status;
		this.hash = hash;
	}

}
