package fr.garage.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CMD_ID")
	private int id;

	@Column(name = "CMD_DATE", nullable = false)
	private LocalDateTime date = LocalDateTime.now();

	@Column(name = "CMD_ETAT", nullable = false)
	@Enumerated(EnumType.STRING)
	private EtatCommande etatCommande = EtatCommande.NONCOMMENCEE;

	@Column(name = "CMD_TOTAL", precision = 10, scale = 2, nullable = false)
	private BigDecimal prixTotal;
	
	@ManyToOne
	@JoinColumn(name="CMD_CLIENT_ID", nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="CMD_VEHICULE_ID", nullable = false)
	private Vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name="CMD_GARAGISTE_ID", nullable = false)
	private Garagiste garagiste;
	
	@OneToMany(mappedBy = "id.commande")
	private List<CommandeDetail> details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	public BigDecimal getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Garagiste getGaragiste() {
		return garagiste;
	}

	public void setGaragiste(Garagiste garagiste) {
		this.garagiste = garagiste;
	}

	public List<CommandeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<CommandeDetail> details) {
		this.details = details;
	}
	
	

}
