package fr.garage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="vehicule")
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEH_ID")
	private int id;
	
	@Column(name="VEH_NOM", length = 40, nullable = false)
	@NotBlank
	@Size(max = 40)
	private String nom;
	
	@Column(name="VEH_MARQUE", length = 40, nullable = false)
	@NotBlank
	@Size(max = 40)
	private String marque;
	
	@Column(name="VEH_IMMATRICULATION", length = 40)
	@Size(max = 40)
	private String immatriculation;
	
	@Column(name="VEH_TYPE", nullable = false)
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "VEH_CLIENT_ID")
	private Client client;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	

}
