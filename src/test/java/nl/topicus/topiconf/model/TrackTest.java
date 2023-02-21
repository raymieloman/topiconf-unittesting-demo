package nl.topicus.topiconf.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackTest {

    private Track track;

    public TrackTest() {
        this.track = new Track();
    }

    @Test
    public void testAddPresentation() {
        Presentation presentation = new Presentation();
        this.track.addPresentation(presentation);

        assertEquals(1, this.track.getSize());
    }
}
