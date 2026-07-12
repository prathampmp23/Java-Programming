package codes;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
 
@Service
public class MessageConsumer {
 
    @KafkaListener(topics = "partition-demo", groupId = "demo-group")
    public void consume(ConsumerRecord<String, String> record) {
 
        System.out.println(
                "📥 Received | Key: " + record.key() +
                " | Value: " + record.value() +
                " | Partition: " + record.partition()
        );
    }
}