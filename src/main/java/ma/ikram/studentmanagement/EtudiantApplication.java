package ma.ikram.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantApplication.class, args);
        System.out.println("==========================================================");
        System.out.println(" Microservice Étudiants (Ikram) démarré avec succès !    ");
        System.out.println(" Interface Swagger : http://localhost:8081/swagger-ui.html");
        System.out.println(" Console H2         : http://localhost:8081/h2-console    ");
        System.out.println("==========================================================");
    }
}
