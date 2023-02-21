package nl.topicus.topiconf.service;

import nl.topicus.topiconf.model.Presentation;
import nl.topicus.topiconf.persistence.PresentationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PresentationServiceTest {

    @InjectMocks
    private PresentationService presentationService;

    @Mock
    private PresentationRepository presentationRepository;

    public PresentationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {

        // Given  (instruct the Mock)
        Presentation mockedPresentation = new Presentation();
        mockedPresentation.setId(3L);
        mockedPresentation.setTitle("Java for Topicus rocks");
        Optional<Presentation> myoptional = Optional.of(mockedPresentation);
        Mockito.when(this.presentationRepository.findById(3L)).thenReturn(myoptional);

        //When
        Presentation presentationFromService = this.presentationService.findById(3L);

        //Then
        assertNotNull(presentationFromService);
        assertEquals(3L, presentationFromService.getId());
        assertEquals("Java for Topicus rocks", presentationFromService.getTitle());
    }
}
