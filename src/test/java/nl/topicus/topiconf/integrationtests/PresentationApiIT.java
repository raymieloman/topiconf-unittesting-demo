package nl.topicus.topiconf.integrationtests;

import nl.topicus.topiconf.model.Presentation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

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

        // set the last Id for using later on fetching by id
        lastId = presentation.getId();
    }

    @Test
    @Order(2)
    public void testList() {
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        // Act
        ResponseEntity<List<Presentation>> response = restTemplate.exchange("/api/presentations",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Presentation>>() {
                });
        List<Presentation> responseBodyAsList = response.getBody();

        // Assert
        assertEquals(1, responseBodyAsList.size());
        assertEquals("Java for us", responseBodyAsList.get(0).getTitle());
    }

    @Test
    @Order(3)
    public void testFindById() {
        // Given => In fact given the imperative instructions given in step 1 and 2

        // When
        ResponseEntity<Presentation> resultFromGet = this.restTemplate.getForEntity("/api/presentations/" + lastId, Presentation.class);

        // Then
        assertEquals(200, resultFromGet.getStatusCode().value());
        Presentation presentationFromGetById = resultFromGet.getBody();
        assertEquals("Java for us", presentationFromGetById.getTitle());
    }
}
