package ascolta.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ascolta.kafka.kafka.KafkaSend;


@Service
public class ServiceProva {

	private Logger logger = LoggerFactory.getLogger(ServiceProva.class);

	@Autowired
	private KafkaSend kafkaSend;
	
	@Value("${uri}")
	private String uri;
	
	public String callMongoDb(String nome) {
		
		String uriFinale = uri + "/"+nome;

		logger.info("uriFinale: "+uriFinale);
		RestTemplate restTemplate = new RestTemplate();
		
		String response = restTemplate.getForObject(uriFinale, String.class);
		
		logger.info("risposta: " + response.toString());
		logger.info("risposta come oggetto: "+response);
		return response;
	}

	public String workWithQueue() {
		
		logger.info("inizio preparazione invio per messaggio");
		
		kafkaSend.sendMessage("Ciao ti invio questto messa", "coda.prova.matteo");
		
		logger.info("Invio avvenuto con successo");
		return null;
	}

}
