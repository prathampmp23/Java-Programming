package codes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/kafka")
public class KafkaController {
 
	@Autowired
    private MessageProducer producer;
 
    @GetMapping("/test")
    public String test() {
 
        // Same key → SAME partition
        producer.send("user1", "msg-10");
        producer.send("user1", "msg-20");
        producer.send("user1", "msg-30");
 
        // Different keys → different partitions
        producer.send("user2", "msg-A1");
        producer.send("user2","msg-A2");
        producer.send("user3", "msg-B1");
 
        return "✅ Messages Sent";
    }
}