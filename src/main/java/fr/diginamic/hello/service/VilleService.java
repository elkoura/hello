package fr.diginamic.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.dao.VilleDAO;
import fr.diginamic.hello.entities.Ville;

/**Classe de service pour les méthodes liées à la classe Ville
 * 
 */
@Service
public class VilleService {
	@Autowired
	private VilleDAO villeDAO;

	
	public List<Ville> extractVilles() {
		return villeDAO.extractVilles();
	}

	/**Ressort une ville
	 * @param id l'ID de la ville à trouver
	 */
	public Ville extractVille(int idVille) {
		return villeDAO.extractVille(idVille);
	}

	/**Insere une ville dans la base de donnée
	 * @param ville La ville à inserer
	 */
	public List<Ville> insertVille(Ville ville) {
		villeDAO.insertVille(ville);
		return extractVilles();
	}
	
	
	public List<Ville> updateVille(int id, Ville ville) {
		villeDAO.updateVille(id, ville);
		return extractVilles();
	}
	
	
	public List<Ville> deleteVille(int idVille) {
		villeDAO.deleteVille(idVille);
		return extractVilles();
	}
	
}