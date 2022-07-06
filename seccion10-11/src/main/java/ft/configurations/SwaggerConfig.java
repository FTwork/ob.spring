package ft.configurations;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * http://localhost:8081/swagger-ui/
 * @author Usuario
 */
@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket api(){
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptop API REST",
                "Laptop api rest docs",
                "1.0",
                "www.google.com",
                new Contact("Franco","www.google.com",
                        "franco@example.com"),
                "MIT",
                "www.google.com",
                Collections.EMPTY_LIST);
    }
}
