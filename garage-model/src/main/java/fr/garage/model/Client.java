package fr.garage.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLI_ID")
	private int id;
	
	@Column(name="CLI_NOM", length = 40 , nullable = false)
	@NotBlank
	@Size(max=40)
	private String nom;
	
	@Column(name="CLI_PRENOM", length = 40 , nullable = false)
	@NotBlank
	@Size(max=40)
	private String prenom;
	
	@Column(name="CLI_RAISON_SOCIALE", length = 40 , nullable = false)
	@NotBlank
	@Size(max=40)
	private String raisonSociale;
	
	
	@Column(name="CLI_TYPE", nullable = false)
	@NotBlank
	@Enumerated(EnumType.STRING)
	private TypeClient typeClient;
	
	@Column(name="CLI_FIDELITE", nullable = false)
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Fidelite fidelite; 
	
	
	@OneToMany(mappedBy = "client")
	private List<Vehicule> vehicules;
	
	
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public TypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}
	public Fidelite getFidelite() {
		return fidelite;
	}
	public void setFidelite(Fidelite fidelite) {
		this.fidelite = fidelite;
	}	
}
