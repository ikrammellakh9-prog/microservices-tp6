package ma.ikram.studentmanagement.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "etudiants")
@Schema(description = "Entité Etudiant avec filière et informations de contact")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant de l'étudiant", example = "101")
    private int id;

    @Column(nullable = false, length = 60)
    @Schema(description = "Nom", example = "Mellakh")
    private String nom;

    @Column(nullable = false, length = 60)
    @Schema(description = "Prénom", example = "Ikram")
    private String prenom;

    @Column(nullable = false, unique = true, length = 100)
    @Schema(description = "Adresse e-mail universitaire", example = "ikram.mellakh@edu.ma")
    private String email;

    @Column(length = 80)
    @Schema(description = "Filière / Spécialité", example = "Génie Logiciel & Microservices")
    private String filiere;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Date de naissance", example = "2002-11-20")
    private Date dateNaissance;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String email, String filiere, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
        this.dateNaissance = dateNaissance;
    }

    public Etudiant(int id, String nom, String prenom, String email, String filiere, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
