package fr.garage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "garagiste")
public class Garagiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GAR_ID")
	private int id;

	@Column(name = "GAR_NOM", length = 40, nullable = false)
	@NotBlank
	@Size(max = 40)
	private String nom;

	@Column(name = "GAR_PRENOM", length = 40)
	@Size(max = 40)
	private String prenom;
	
	@Column(name = "GAR_EMAIL", length = 150, nullable = false)
	@NotBlank
	@Size(max = 150)
	@Email
	private String email;
	
	@Column(name = "GAR_PASSWORD", length = 255, nullable = false)
	@NotBlank
	@Size(max = 255)
	private String password;
	
	@Column(name = "GAR_ROLE", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeRole role = TypeRole.USER;
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeRole getRole() {
		return role;
	}

	public void setRole(TypeRole role) {
		this.role = role;
	}

	
}
