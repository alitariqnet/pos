package dev.ali.pos.service;

import dev.ali.pos.entity.Cashier;
import dev.ali.pos.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {
    private static final Logger log = LoggerFactory.getLogger(SalesService.class);
    @Autowired
    private UserService userService;

    public SalesService() {
    }

    public SalesService(UserService userService) {
        this.userService = userService;
    }

    public void simulateSales(){

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
        userService.create(cashier);
        log.info("New cashier created ->", cashier);
    }

}
