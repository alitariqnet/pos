package dev.ali.pos.service;

import dev.ali.pos.entity.Cashier;
import dev.ali.pos.entity.Manager;
import dev.ali.pos.entity.User;
import dev.ali.pos.repository.CashierRepository;
import dev.ali.pos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashierService {
    private static final Logger log = LoggerFactory.getLogger(CashierService.class);
    @Autowired
    private CashierRepository cashierRepository;

    @Autowired
    private UserRepository userRepository;


    public Cashier create(String firstName, String lastName, String email, String phone, String address, String gender, String username, String password) {
        log.info("First name -> "+firstName+" Last name -> "+lastName+" email -> "+email+" phone -> "+address+" gender -> "+gender+" username -> "+username);
//        Optional<User> user = userRepository.findByUsername(username);
        Cashier cashier = null;
//        if (user.isPresent()) {
//            log.info("Username already exists please choose another username");
//        } else
        {
            Cashier cashier1 = new Cashier();
            cashier1.setFirstName(firstName);
            cashier1.setLastName(lastName);
            cashier1.setEmail(email);
            cashier1.setPhone(phone);
            cashier1.setAddress(address);
            cashier1.setGender(gender);
            cashier1.setUsername(username);
            cashier1.setPassword(password);
            cashier1.setRole("ROLE_USER");
            cashier1.setActive(true);
            cashier = this.create(cashier1);
        }
        return cashier;
    }
    public Cashier create(Cashier cashier){
        return cashierRepository.save(cashier);
    }
    public void delete(Cashier cashier){
        cashierRepository.delete(cashier);
        log.info("Cashier account deleted..");
    }
    public Cashier update(Cashier cashier){
        return cashierRepository.save(cashier);
    }
}
