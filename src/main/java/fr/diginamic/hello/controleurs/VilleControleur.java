package fr.diginamic.hello.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<String> addVille(@RequestBody Ville nouvelleVille) {
        for (Ville ville : villes) {
            if (ville.getNom().equalsIgnoreCase(nouvelleVille.getNom())) {
                return new ResponseEntity<>("La ville existe déjà", HttpStatus.BAD_REQUEST);
            }
        }
        villes.add(nouvelleVille);
        return new ResponseEntity<>("Ville insérée avec succès", HttpStatus.OK);
    }
    
    
}
