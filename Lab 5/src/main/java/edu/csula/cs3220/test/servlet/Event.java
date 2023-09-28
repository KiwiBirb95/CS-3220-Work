package edu.csula.cs3220.test.servlet;

import java.util.Date;

public class Event {
    private String name;
    private Date eventDate;
    private String createdBy;

    // Constructors
    public Event(String name, Date eventDate, String createdBy) {
        this.name = name;
        this.eventDate = eventDate;
        this.createdBy = createdBy;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
