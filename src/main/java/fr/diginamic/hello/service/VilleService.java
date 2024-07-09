package fr.diginamic.hello.service;

import fr.diginamic.hello.entities.Departement;
import fr.diginamic.hello.entities.Ville;
import fr.diginamic.hello.repository.DepartementRepository;
import fr.diginamic.hello.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class VilleService {

	@Autowired
	private VilleRepository villeRepository;

	@Autowired
	private DepartementRepository departementRepository;

	@Transactional
	public void importVillesFromCsv(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				if (fields.length >= 9 && !fields[0].equals("Code région")) {
					String nomDepartement = fields[1];
					int codeDepartement = Integer.parseInt(fields[2]);
					String nomVille = fields[6];
					int population = Integer.parseInt(fields[7].replaceAll(" ", ""));

					Departement departement = departementRepository.findByCode(codeDepartement);
					if (departement == null) {
						departement = new Departement();
						departement.setCode(codeDepartement);
						departement.setNom(nomDepartement);
						departementRepository.save(departement);
					}

					Ville ville = new Ville();
					ville.setNom(nomVille);
					ville.setNbHabitants(population);
					ville.setDepartement(departement);
					villeRepository.save(ville);
				}
			}
		} catch (IOException e) {
			// Gestion des exceptions liées à la lecture du fichier CSV
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// Gestion des exceptions de conversion de nombre
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	public List<Ville> findTopNVillesByDepartementCode(int departementCode, int n) {
		return villeRepository.findTopNByDepartementCodeOrderByNbHabitantsDesc(departementCode, PageRequest.of(0, n)).getContent();
	}
}

