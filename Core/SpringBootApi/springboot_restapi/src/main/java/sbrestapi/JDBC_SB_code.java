package sbrestapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBC_SB_code {

    AlienRepository repo = new AlienRepository();

    // GET all aliens
    @GetMapping("/aliens")
    public List<Alien> getAliens() {
    return repo.getAliens();
    }

    // GET alien by ID
    @GetMapping("/aliens/{id}")
    public Alien getAlienById(@PathVariable int id) {
        return repo.getAlien(id);
    }

    // CREATE alien
    @PostMapping("/aliens")
    public Alien createAlien(@RequestBody Alien a) {
        repo.createAlien(a);
        return a;
    }

    // UPDATE alien
    @PutMapping("/aliens/{id}")
    public void updateAlien(@RequestBody Alien a, @PathVariable int id) {
        repo.updateAlien(a, id);
    }

    // DELETE alien
    @DeleteMapping("/aliens/{id}")
    public Alien deleteAlien(@PathVariable int id) {
        Alien a = repo.getAlien(id);
        if (a.getId() != 0) {
            repo.deleteAlien(id);
        }
        return a;
    }
}
