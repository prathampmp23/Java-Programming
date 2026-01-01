package com.restapi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class AlienRepository {
    List<Alien> aliens;

    public AlienRepository() {
        System.out.println("Alien is called!");
        aliens = new ArrayList<>();

        Alien a1 = new Alien();
        a1.setId(101);
        a1.setName("Pratham");
        a1.setPoints(61);
        aliens.add(a1);

        Alien a2 = new Alien();
        a2.setId(102);
        a2.setName("Rishabh");
        a2.setPoints(57);
        aliens.add(a2);

        Alien a3 = new Alien();
        a3.setId(102);
        a3.setName("Manthan");
        a3.setPoints(55);
        aliens.add(a3);
    }

    // get all aliens
    public List<Alien> getAliens() {
        return aliens;
    }

    // get specific id aliens
    public Alien getAlien(int id) {
        for (Alien a : aliens) {
            if (a.getId() == id)
                return a;
        }
        return null;
    }

    // create new alien
    public void createAlien(Alien a) {
        
    }
}
