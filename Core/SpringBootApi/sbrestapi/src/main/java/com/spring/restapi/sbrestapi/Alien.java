package com.spring.restapi.sbrestapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marks class as DB table
@Table(name = "aliens") // Maps entity to table
public class Alien {
    @Id // makes id as primary key
    private int id;
    private String name;
    private int points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Alien [name=" + name + ", id=" + id + ", points=" + points + "]";
    }

}
