package codes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class MessageProducer {
 
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
 
    public void send(String key, String value) {
 
        kafkaTemplate.send("partition-demo", key, value)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println(
                                "✅ Sent | Key: " + key +
                                " | Value: " + value +
                                " | Partition: " +
                                result.getRecordMetadata().partition()
                        );
                    }
                });
    }
}