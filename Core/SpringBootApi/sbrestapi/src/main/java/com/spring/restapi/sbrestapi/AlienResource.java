package com.spring.restapi.sbrestapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {

    // Access url http://127.0.0.1:8081/aliens
    @Autowired
    AlienRepository repo;

    // CREATE (Insert)
    @PostMapping("/aliens")
    public Alien createAlien(@RequestBody Alien alien) {
        return repo.save(alien);
    }

    // READ (Select)
    @GetMapping("aliens")
    public List<Alien> getAliens() {
        List<Alien> aliens = (List<Alien>) repo.findAll();
        return aliens;
    }

    // Find by ID
    @GetMapping("/aliens/{id}")
    public Alien getAlien(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/aliens/{id}")
    public Alien updateAlien(@RequestBody Alien alien, @PathVariable int id) {
        alien.setId(id);
        return repo.save(alien);
    }

    // DELETE
    @DeleteMapping("/aliens/{id}")
    public void deleteAlien(@PathVariable int id) {
        repo.deleteById(id);
    }
}
