package ma.ikram.studentmanagement.controllers;

import ma.ikram.studentmanagement.entities.Etudiant;
import ma.ikram.studentmanagement.services.EtudiantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantControllerTest {

    @Mock
    private EtudiantService etudiantService;

    @InjectMocks
    private EtudiantController etudiantController;

    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @BeforeEach
    void setUp() {
        etudiant1 = new Etudiant(1, "Mellakh", "Ikram", "ikram.mellakh@edu.ma", "Génie Logiciel", new Date());
        etudiant2 = new Etudiant(2, "Bennani", "Salma", "salma.bennani@edu.ma", "Intelligence Artificielle", new Date());
    }

    @Test
    @DisplayName("Tester l'ajout d'un étudiant avec statut 201 CREATED")
    void testAjouterEtudiant() {
        when(etudiantService.enregistrer(any(Etudiant.class))).thenReturn(etudiant1);

        ResponseEntity<Etudiant> response = etudiantController.ajouter(etudiant1);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Mellakh", response.getBody().getNom());
        verify(etudiantService, times(1)).enregistrer(any(Etudiant.class));
    }

    @Test
    @DisplayName("Tester la liste des étudiants avec statut 200 OK")
    void testObtenirTous() {
        List<Etudiant> liste = Arrays.asList(etudiant1, etudiant2);
        when(etudiantService.obtenirTous()).thenReturn(liste);

        ResponseEntity<List<Etudiant>> response = etudiantController.obtenirTous();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(etudiantService, times(1)).obtenirTous();
    }

    @Test
    @DisplayName("Tester la suppression réussie")
    void testSupprimerSuccess() {
        when(etudiantService.supprimer(1)).thenReturn(true);

        ResponseEntity<Void> response = etudiantController.supprimer(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(etudiantService, times(1)).supprimer(1);
    }

    @Test
    @DisplayName("Tester le total des étudiants")
    void testCompter() {
        when(etudiantService.compterEtudiants()).thenReturn(150L);

        ResponseEntity<Long> response = etudiantController.compter();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(150L, response.getBody());
        verify(etudiantService, times(1)).compterEtudiants();
    }
}
