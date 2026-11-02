package ma.ikram.studentmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Service de Gestion Académique des Étudiants")
                        .version("1.0.0")
                        .description("Microservice Spring Boot avec persistance H2/MySQL et documentation interactive OpenAPI Swagger. Conçu par Ikram Mellakh.")
                        .contact(new Contact()
                                .name("Ikram Mellakh")
                                .email("ikrammelakh9@gmail.com"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
