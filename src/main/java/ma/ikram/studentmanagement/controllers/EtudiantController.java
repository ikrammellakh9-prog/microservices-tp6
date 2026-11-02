package ma.ikram.studentmanagement.controllers;

import ma.ikram.studentmanagement.entities.Etudiant;
import ma.ikram.studentmanagement.services.EtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("etudiants")
@Tag(name = "Gestion Académique", description = "Services REST d'administration des étudiants et statistiques de scolarité")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Operation(summary = "Ajouter un étudiant", description = "Crée un nouvel étudiant avec filière et coordonnées dans le système")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Étudiant créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping("/ajouter")
    public ResponseEntity<Etudiant> ajouter(@RequestBody Etudiant etudiant) {
        Etudiant saved = etudiantService.enregistrer(etudiant);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(summary = "Supprimer un étudiant", description = "Supprime un étudiant à partir de son numéro d'identification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Suppression effectuée"),
            @ApiResponse(responseCode = "404", description = "Étudiant non trouvé")
    })
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer(@Parameter(description = "Identifiant numérique de l'étudiant") @PathVariable("id") int id) {
        boolean ok = etudiantService.supprimer(id);
        if (ok) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Consulter la liste de tous les étudiants", description = "Retourne l'annuaire complet des étudiants inscrits")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping("/liste")
    public ResponseEntity<List<Etudiant>> obtenirTous() {
        return new ResponseEntity<>(etudiantService.obtenirTous(), HttpStatus.OK);
    }

    @Operation(summary = "Nombre total des effectifs", description = "Compte le nombre total d'étudiants enregistrés")
    @ApiResponse(responseCode = "200", description = "Effectif total retourné")
    @GetMapping("/total")
    public ResponseEntity<Long> compter() {
        return new ResponseEntity<>(etudiantService.compterEtudiants(), HttpStatus.OK);
    }

    @Operation(summary = "Répartition par filière", description = "Statistiques ventilées par département et filière d'études")
    @ApiResponse(responseCode = "200", description = "Statistiques de filière générées")
    @GetMapping("/stats/filiere")
    public ResponseEntity<Collection<?>> statsFiliere() {
        return new ResponseEntity<>(etudiantService.obtenirStatistiquesFiliere(), HttpStatus.OK);
    }

    @Operation(summary = "Répartition par année de naissance", description = "Statistiques démographiques par tranche d'âge/année")
    @ApiResponse(responseCode = "200", description = "Statistiques par année générées")
    @GetMapping("/stats/annee")
    public ResponseEntity<Collection<?>> statsAnnee() {
        return new ResponseEntity<>(etudiantService.obtenirStatistiquesAnnee(), HttpStatus.OK);
    }
}
