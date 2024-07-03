package fr.diginamic.hello.controleurs;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entitie.Ville;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    private List<Ville> villes = new ArrayList<>();

    public VilleControleur() {
        villes.add(new Ville(1,"paris", 34));
        villes.add(new Ville(2,"nice", 342));
        villes.add(new Ville(3,"NIME", 344));
    }

    @GetMapping
    public List<Ville> getVille() {
        return villes;
    }

	/*
	 * @PostMapping public ResponseEntity<String> addVille(@RequestBody Ville
	 * nouvelleVille) { for (Ville ville : villes) { if
	 * (ville.getNom().equalsIgnoreCase(nouvelleVille.getNom())) { return new
	 * ResponseEntity<>("La ville existe déjà", HttpStatus.BAD_REQUEST);// } }
	 * villes.add(nouvelleVille); return new
	 * ResponseEntity<>("Ville insérée avec succès", HttpStatus.OK); }
	 */
    
    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable int id) {
    	Optional<Ville> ville=villes.stream().filter(v -> v.getId() == id).findFirst();
    	if(ville.isPresent()) {
    		return new ResponseEntity<>(ville.get(), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @PostMapping
    ResponseEntity<String> addVille(@RequestBody Ville nouvelleVille) {
        for(Ville ville :villes) {
        	if (ville.getId()==nouvelleVille.getId()) {
        		return new ResponseEntity<>("la ville avec ID exist ", HttpStatus.BAD_REQUEST);
        	}
        }
        villes.add(nouvelleVille);
        return new ResponseEntity<>("Ville insérée avec succès", HttpStatus.OK);

        }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateVille(@PathVariable int id, @RequestBody Ville updatedVille) {
        for (Ville ville : villes) {
            if (ville.getId() == id) {
                ville.setNom(updatedVille.getNom());
                ville.setNbHabitants(updatedVille.getNbHabitants());
                return new ResponseEntity<>("Ville mise à jour avec succès", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Ville non trouvée", HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletVille(@PathVariable int id){
    	for(Ville ville : villes) {
    		if (ville.getId()==id) {
    			villes.remove(ville);
    			return new ResponseEntity<>("la ville est supprim", HttpStatus.OK);
    				
    			}
    	}
			return new ResponseEntity<>("Ville non trouvé", HttpStatus.NOT_FOUND);

    		
    		}
    	}
    

        
    
    

    
    

