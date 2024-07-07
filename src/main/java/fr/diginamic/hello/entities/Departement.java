package fr.diginamic.hello.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Représente un département avec un nom et une collection de villes.
 * Chaque département peut contenir plusieurs villes.
 */
@Entity
@Table(name = "departement")
public class Departement {
    
    /** Identifiant unique du département, généré automatiquement */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    /** Nom du département, ne peut pas être null et doit avoir au moins 2 caractères */
    @NotNull
    @Size(min = 2)
    protected String nom;
    
    protected int code;

    /** Ensemble des villes appartenant au département */
    @OneToMany(mappedBy = "departement")
    private Set<Ville> villes = new HashSet<>();

    /**
     * Constructeur avec paramètres.
     * 
     * @param nom Nom du département, doit avoir au moins 2 caractères et ne peut pas être null
     */
    public Departement(@NotNull @Size(min = 2) String nom) {
        this.nom = nom;
    }

    public Departement(int code) {
        this.code = code;
    }

    /** Constructeur sans paramètres pour l'usage de JPA */
    public Departement() {
    }
    
    /**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
     * Retourne le nom du département.
     * 
     * @return le nom du département
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du département.
     * 
     * @param nom Nom du département
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'identifiant du département.
     * 
     * @return l'identifiant du département
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne l'ensemble des villes appartenant au département.
     * 
     * @return l'ensemble des villes
     */
    public Set<Ville> getVilles() {
        return villes;
    }

    /**
     * Définit l'ensemble des villes appartenant au département.
     * 
     * @param villes Ensemble des villes
     */
    public void setVilles(Set<Ville> villes) {
        this.villes = villes;
    }
}
