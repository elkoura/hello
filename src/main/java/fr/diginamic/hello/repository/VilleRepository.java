package fr.diginamic.hello.repository;

import org.springframework.data.repository.CrudRepository;

import fr.diginamic.hello.entities.Ville;

public interface VilleRepository extends CrudRepository <Ville, Integer> {
	Ville findByNom(String nom);
	
	

}
