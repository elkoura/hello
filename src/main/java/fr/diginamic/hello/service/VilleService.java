package fr.diginamic.hello.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import fr.diginamic.hello.dao.DepartementDAO;
import fr.diginamic.hello.entities.Departement;

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
	 * @param idVille Ville l'ID de la ville à trouver
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

	public void importVillesFromCsv(String csvFilePath) {
		String line = "";
		String csvSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			while ((line = br.readLine()) != null) {
				String[] villeData = line.split(csvSplitBy);

				if (villeData.length >= 4) {
					String codeDepartement = villeData[0];
					String nomDepartement = villeData[1];
					String nomVille = villeData[2];
					int population = Integer.parseInt(villeData[3]);

					DepartementDAO departementDAO = new DepartementDAO();
					Departement departement = departementDAO.findByName(nomDepartement);
					if (departement == null) {
						departement = new Departement(nomDepartement);
						departementDAO.insertDepartement(departement);
					}

					Ville ville = new Ville(nomVille, population);
					ville.setDepartement(departement);

					villeDAO.insertVille(ville);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}