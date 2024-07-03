package entitie;

public class Ville {
	
	private int id;

	private String nom;
	private int nbHabitants;
	
	
	/**
	 * @param nbHabitants
	 * @param nom
	 */
	public Ville(int id ,String nom, int nbHabitants) {
		super();
		this.id=id;
		this.nom = nom;
		this.nbHabitants = nbHabitants;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the nbHabitants
	 */
	public int getNbHabitants() {
		return nbHabitants;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param nbHabitants the nbHabitants to set
	 */
	public void setNbHabitants(int nbHabitants) {
		this.nbHabitants = nbHabitants;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

}
