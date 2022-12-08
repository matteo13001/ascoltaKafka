package ascolta.kafka.kafka;

import org.apache.tomcat.util.net.WriteBuffer.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {

	private Logger logger = LoggerFactory.getLogger(kafkaListener.class);

//	@KafkaListener(topics = "coda.prova.matteo", groupId = "matteoGroups")
//	public boolean ascoltaConGroup(String message) {
//
//		logger.info("Messaggio ricevuto dal listenere con il groupID: " + message);
//
//		return true;
//	}
//
//	@KafkaListener(topics = "coda.prova.matteo")
//	public boolean acoltaSenzaGroup(String message) {
//
//		logger.info("Messaggio ricevuto senza il groupID: " + message);
//
//		return true;
//	}
//
//	@KafkaListener(topicPartitions = @TopicPartition(topic = "coda.prova.matteo", partitionOffsets = {
//			@PartitionOffset(partition = "0", initialOffset = "0"),
//			@PartitionOffset(partition = "3", initialOffset = "0") }))
//	public boolean listenOnPartition(String message) {
//
//		logger.info("Ricevuto: listenOnPartition" + message);
//		return true;
//
//	}

	@KafkaListener( topicPartitions =
        { @TopicPartition(topic = "mattei.prova.party", partitions = { "1" })}, groupId = "matteoGroups"
			)
	public void listen() {
		
		
		logger.info("Prova Adalberto");
	}

}
