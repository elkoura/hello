package fr.diginamic.hello.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.dao.DepartementDAO;
import fr.diginamic.hello.entities.Departement;
import fr.diginamic.hello.entities.Ville;
import jakarta.validation.Valid;

/**Classe de service pour les méthodes liées à la classe Departement
* 
*/
@Service
public class DepartementContoleur{
	@Autowired
	private DepartementDAO depDAO;

	/**Ressort tous les départements
	 * 
	 */
	public List<Departement> extractDepartements() {

		return depDAO.extractDepartements();
	}

	/**Ressort un département
	 * @param id L'ID du département à trouver
	 */
	public Departement extractDepartement(int id) {

		return depDAO.extractDepartement(id);
	}
	
	/**Insere un département dans la base de donnée
	 * @param newDepartement Le département à inserer
	 */
	public void insertDepartement(@Valid Departement newDepartement) {
		depDAO.insertDepartement(newDepartement);

	}

	/**Modifie un département donné
	 * @param id L'id du département à modifier
	 * @param departement Les nouvelles données
	 */
	public void updateDepartement(int id, @Valid Departement departement) {

		depDAO.updateDepartement(id, departement);
	}


}