package nl.topicus.topiconf.api;

import nl.topicus.topiconf.model.Presentation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PresentationApiIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private static long lastId = -1;

    @Test
    @Order(1)
    public void testPost() {

        // Given
        Presentation presentationToBePosted = new Presentation();
        presentationToBePosted.setTitle("Java for us");

        // When
        ResponseEntity<Presentation> result = this.restTemplate.postForEntity("/api/presentations", presentationToBePosted, Presentation.class);

        // Then
        assertEquals(200, result.getStatusCode().value());

        // And
        Presentation presentation = result.getBody();
        assertEquals("Java for us", presentation.getTitle());
        System.err.println(presentation.getId());

       lastId = presentation.getId();
    }

    @Test
    @Order(2)
    public void testFindById() {

        // Given

        // When
        ResponseEntity<Presentation> resultFromGet = this.restTemplate.getForEntity("/api/presentations/"+lastId, Presentation.class);

        assertEquals(200, resultFromGet.getStatusCode().value());
        Presentation presentationFromGetById = resultFromGet.getBody();

        assertEquals("Java for us", presentationFromGetById.getTitle());
    }
}
