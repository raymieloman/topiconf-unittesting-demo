package nl.topicus.topiconf.model;

public class Presentation {

    private String title;
    private int attendees;
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void incrementAttendees() {
        this.attendees++;
    }
}
