package fr.diginamic.hello.repository;



import fr.diginamic.hello.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
	List<Ville> findByNomStartingWith(String prefix);
	List<Ville> findByNbHabitantsGreaterThan(int min);
	List<Ville> findByNbHabitantsBetween(int min, int max);
	List<Ville> findByDepartementCodeAndNbHabitantsGreaterThan(int departementCode, int min);
	List<Ville> findByDepartementCodeAndNbHabitantsBetween(int departementCode, int min, int max);
	@Query("SELECT v FROM Ville v WHERE v.departement.code = :departementCode ORDER BY v.nbHabitants DESC")
	Page<Ville> findTopNByDepartementCodeOrderByNbHabitantsDesc(@Param("departementCode") int departementCode, Pageable pageable);
}
