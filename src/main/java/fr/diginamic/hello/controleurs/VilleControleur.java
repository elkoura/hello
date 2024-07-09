package fr.diginamic.hello.controleurs;

import fr.diginamic.hello.entities.Ville;
import fr.diginamic.hello.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

	@Autowired
	private VilleRepository villeRepository;

	@GetMapping
	public Page<Ville> trouverVilles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return villeRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Ville trouverVille(@PathVariable Long id) {
		return villeRepository.findById(id).orElse(null);
	}

	@GetMapping("/nom/{nom}")
	public List<Ville> trouverVilleParNom(@PathVariable String nom) {
		return villeRepository.findByNomStartingWith(nom);
	}

	@GetMapping("/population/min/{min}")
	public List<Ville> trouverVillesParPopulationMin(@PathVariable int min) {
		return villeRepository.findByNbHabitantsGreaterThan(min);
	}

	@GetMapping("/population/{min}/{max}")
	public List<Ville> trouverVillesParPopulation(@PathVariable int min, @PathVariable int max) {
		return villeRepository.findByNbHabitantsBetween(min, max);
	}

	@GetMapping("/departement/{departementCode}/population/min/{min}")
	public List<Ville> trouverVillesParDepartementEtPopulationMin(@PathVariable int departementCode, @PathVariable int min) {
		return villeRepository.findByDepartementCodeAndNbHabitantsGreaterThan(departementCode, min);
	}

	@GetMapping("/departement/{departementCode}/population/{min}/{max}")
	public List<Ville> trouverVillesParDepartementEtPopulation(@PathVariable int departementCode, @PathVariable int min, @PathVariable int max) {
		return villeRepository.findByDepartementCodeAndNbHabitantsBetween(departementCode, min, max);
	}

	@GetMapping("/departement/{departementCode}/top/{n}")
	public List<Ville> trouverTopVillesParDepartement(@PathVariable int departementCode, @PathVariable int n) {
		return villeRepository.findTopNByDepartementCodeOrderByNbHabitantsDesc(departementCode, PageRequest.of(0, n)).getContent();
	}


}
