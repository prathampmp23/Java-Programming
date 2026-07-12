package codes;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
 
@Service
public class KafkaMessageConsumer {
 
    @KafkaListener(
        topics = "${kafka.topic.name}",
        groupId = "test-consumer-group"
    )
    public void consumeMessage(
            ConsumerRecord<String, String> record,
            Acknowledgment acknowledgment) {
 
        System.out.println("Received message:");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());
 
        // Manually commit offset
        acknowledgment.acknowledge();
    }
}
