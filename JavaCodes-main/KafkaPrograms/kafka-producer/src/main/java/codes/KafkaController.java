package codes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
 
    private final KafkaProducerService producerService;
 
    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }
 
    @PostMapping("/publish")
    public String sendMessage(@RequestParam String message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka topic";
    }
}