package nl.topicus.topiconf.model;

import javax.persistence.*;

@Entity
public class Presentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int attendees;
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
