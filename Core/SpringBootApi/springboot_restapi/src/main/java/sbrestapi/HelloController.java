package sbrestapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController // annotation for REST Api
public class HelloController {
    @GetMapping("/hello") // this is annotation of mapping request to below method
    public String sayHello() {
        return "Hello to spring boot!";
    }
}
