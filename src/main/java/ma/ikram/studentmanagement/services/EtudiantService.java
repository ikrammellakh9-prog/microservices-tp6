package ma.ikram.studentmanagement.services;

import ma.ikram.studentmanagement.entities.Etudiant;
import ma.ikram.studentmanagement.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant enregistrer(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public boolean supprimer(int id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Etudiant> obtenirTous() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> obtenirParId(int id) {
        return etudiantRepository.findById(id);
    }

    public long compterEtudiants() {
        return etudiantRepository.count();
    }

    public Collection<?> obtenirStatistiquesFiliere() {
        return etudiantRepository.countByFiliere();
    }

    public Collection<?> obtenirStatistiquesAnnee() {
        return etudiantRepository.countByYear();
    }
}
