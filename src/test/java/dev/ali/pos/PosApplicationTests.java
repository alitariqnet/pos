package dev.ali.pos;

import dev.ali.pos.entity.Cashier;
import dev.ali.pos.entity.User;
import dev.ali.pos.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class PosApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(PosApplicationTests.class);

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void setup() {
		log.info("Going to perform test cases...");
	}

	@Test
	void simulateCreateCashier(){
		Cashier cashier = new Cashier();
		cashier.setFirstName("Ali");
		cashier.setLastName("Tariq");
		cashier.setGender("m");
		cashier.setRole("ROLE_USER");
		cashier.setUsername("alibaba");
		// Bcrypt password encryption is left because it is to not required for this demo system
		// Passwords should be saved in encrypted form in database
		cashier.setPassword("pass");
		cashier.setAddress("Shalamar link road");
		cashier.setPhone("1234567");
		User user = userService.create(cashier);
		assertNotNull(user);
		log.info("New cashier created ->", cashier);
	}
}
