package spring.civilstatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registre")
public class Registre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomRegistre;
	private String typeRegistre;
	@ManyToOne
	private Annexe annexe;

	public Annexe getAnnexe() {
		return annexe;
	}

	public void setAnnexe(Annexe annexe) {
		this.annexe = annexe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomRegistre() {
		return nomRegistre;
	}

	public void setNomRegistre(String nomRegistre) {
		this.nomRegistre = nomRegistre;
	}

	public String getTypeRegistre() {
		return typeRegistre;
	}

	public void setTypeRegistre(String typeRegistre) {
		this.typeRegistre = typeRegistre;
	}

	public Registre(int id, String nomRegistre, String typeRegistre, Annexe annexe) {
		super();
		this.id = id;
		this.nomRegistre = nomRegistre;
		this.typeRegistre = typeRegistre;
		this.annexe = annexe;
	}

	public Registre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}