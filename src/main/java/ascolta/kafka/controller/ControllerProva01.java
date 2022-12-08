package ascolta.kafka.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ascolta.kafka.service.ServiceProva;

@RestController
@RequestMapping("/mysql")
public class ControllerProva01 {

	private static Logger logger = LoggerFactory.getLogger(ControllerProva01.class);

	@Autowired
	private ServiceProva serviceProva;

	@GetMapping("/prova")
	public boolean getListaQuery() {
		logger.info("Hello STOCAZZO");
		return true;
	}

	@GetMapping("/raggiungi-Mongodb/{nome}")
	public String getMongodb(@RequestHeader(name = "Computer") String computer,
			@PathVariable(name = "nome") String nome) {

		logger.info("Valori in input: Headers: Computer: " + computer);
		logger.info("Valori in input: Body: nome: " + nome);
		stampaOra("inizio: ");

		String id = serviceProva.callMongoDb(nome);

		stampaOra("fine: ");

		return id;

	}

	
	
	@GetMapping("/vai di coda bello")
	public String sendQueue() {
		
		stampaOra("inizio: ");

		String id = serviceProva.workWithQueue();

		stampaOra("fine: ");

		return id;
	}
	
	public void stampaOra(String tipo) {
		try {
			logger.info(tipo + LocalDateTime.now());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
