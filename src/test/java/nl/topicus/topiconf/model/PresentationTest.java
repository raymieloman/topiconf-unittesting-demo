package nl.topicus.topiconf.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PresentationTest {

    private Presentation presentation;

    // This  constructor is invoked every time a @Test annotated method is run
    public PresentationTest() {
        this.presentation = new Presentation();
    }

    @Test
    public void testSetAndGetTitle() {
        presentation.setTitle("Java for Starters");
        assertEquals("Java for Starters", presentation.getTitle());
    }

    @Test
    public void testSetAndIncrementTheAttendees() {
        presentation.setAttendees(5);
        assertEquals(5, presentation.getAttendees());

        presentation.incrementAttendees();
        assertEquals(6, this.presentation.getAttendees());
    }
}
