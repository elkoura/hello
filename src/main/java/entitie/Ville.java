package entitie;

public class Ville {
	
	private int id;

	private String nom;
	private long nbHabitants;
	
	
	/**
	 * @param nbHabitants
	 * @param nom
	 * @param id 
	 */
	public Ville(int id ,String nom, long nbHabitants) {
		super();
		this.id= id;
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
	public long getNbHabitants() {
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
	public void setNbHabitants(long nbHabitants) {
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
