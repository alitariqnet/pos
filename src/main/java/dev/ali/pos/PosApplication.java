package dev.ali.pos;

import dev.ali.pos.service.SalesService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosApplication {

	private static final Logger log = LoggerFactory.getLogger(PosApplication.class);

	@Autowired
	private SalesService salesService;

	static{

	}

	public static void main(String[] args) {
		log.info("Starting POS application...");
		SpringApplication.run(PosApplication.class, args);
        // TODO: command line runner for initial values
		log.info("Starting simulate sales service...");
	}

	@PostConstruct
	public void simulate(){
		log.info("Inside PostConstruct");
		salesService.simulateSales();
	}

}
