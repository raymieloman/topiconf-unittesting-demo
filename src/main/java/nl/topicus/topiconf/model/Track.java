package nl.topicus.topiconf.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<Presentation> presentationList = new ArrayList<>();

    public int getSize() {
        return this.presentationList.size();
    }

    public void addPresentation(Presentation presentation) {
        this.presentationList.add(presentation);
    }
}
