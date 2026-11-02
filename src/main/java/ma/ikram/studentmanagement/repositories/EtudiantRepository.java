package ma.ikram.studentmanagement.repositories;

import ma.ikram.studentmanagement.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Optional<Etudiant> findByEmail(String email);

    // Requête JPQL personnalisée : répartition des effectifs par filière
    @Query("SELECT e.filiere, COUNT(e) FROM Etudiant e GROUP BY e.filiere")
    Collection<Object[]> countByFiliere();

    // Requête JPQL par année de naissance
    @Query("SELECT YEAR(e.dateNaissance), COUNT(e) FROM Etudiant e GROUP BY YEAR(e.dateNaissance)")
    Collection<Object[]> countByYear();
}
