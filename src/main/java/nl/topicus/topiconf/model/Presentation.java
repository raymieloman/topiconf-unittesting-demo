package nl.topicus.topiconf.model;

public class Presentation {

    private String title;
    private int attendees;

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void incrementAttendees() {
        this.attendees++;
    }
}
