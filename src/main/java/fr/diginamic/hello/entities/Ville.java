package fr.diginamic.hello.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Représente une ville avec un nom, un nombre d'habitants et un département associé.
 */
@Entity
@Table(name = "ville")
public class Ville {
    
    /** Identifiant unique de la ville, généré automatiquement */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /** Nom de la ville, ne peut pas être null et doit avoir au moins 2 caractères */
    @NotNull
    @Size(min = 2)
    protected String nom;

    /** Nombre d'habitants dans la ville, doit être au moins de 1 */
    @Min(value = 1)
    protected int nbHabitants;

    /** Département auquel appartient la ville */
    @ManyToOne
    protected Departement departement;

    /**
     * Constructeur avec paramètres.
     * 
     * @param nom Nom de la ville, doit avoir au moins 2 caractères et ne peut pas être null
     * @param nbHabitants Nombre d'habitants dans la ville, doit être au moins de 1
     */
    public Ville(@NotNull @Size(min = 2) String nom, @Min(value = 1) int nbHabitants) {
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    /** Constructeur sans paramètres pour l'usage de JPA */
    public Ville() {
    }

    /**
     * Retourne le nom de la ville.
     * 
     * @return le nom de la ville
     */
    
    
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la ville.
     * 
     * @param nom Nom de la ville
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le nombre d'habitants de la ville.
     * 
     * @return le nombre d'habitants de la ville
     */
    public int getNbHabitants() {
        return nbHabitants;
    }

    /**
     * Définit le nombre d'habitants de la ville.
     * 
     * @param nbHabitants Nombre d'habitants de la ville
     */
    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    /**
     * Retourne l'identifiant de la ville.
     * 
     * @return l'identifiant de la ville
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la ville.
     * 
     * @param id Identifiant de la ville
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le département auquel appartient la ville.
     * 
     * @return le département de la ville
     */
    public Departement getDepartement() {
        return departement;
    }

    /**
     * Définit le département auquel appartient la ville.
     * 
     * @param departement Département de la ville
     */
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
