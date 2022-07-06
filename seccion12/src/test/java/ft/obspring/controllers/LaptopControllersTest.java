package ft.obspring.controllers;

import ft.obspring.entities.Laptop;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaptopControllersTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        ResponseEntity<String> response
                = testRestTemplate.getForEntity("/hola", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals("Hola mundo como va putines", response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response
                = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response
                = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        
                Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        
    }

    @Test
    void save() {
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        String json = """
                      {
                          "id":1,
                          "color":"negro",
                          "model": "HP-240",
                          "price": 70000.00
                      }
                      """;
        
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        
        ResponseEntity<Laptop> response =
        testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);
        
        Laptop result = response.getBody();
        
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("negro", result.getColor());
        
    }

}
