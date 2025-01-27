package dev.ali.pos.service;

import dev.ali.pos.entity.Manager;
import dev.ali.pos.entity.User;
import dev.ali.pos.repository.ManagerRepository;
import dev.ali.pos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    private static final Logger log = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private UserRepository userRepository;


    public Manager create(String firstName, String lastName, String email, String phone, String address, String gender, String username, String password) {
        log.info("First name -> "+firstName+" Last name -> "+lastName+" email -> "+email+" phone -> "+address+" gender -> "+gender+" username -> "+username);

//        Optional<User> user = userRepository.findByUsername(username);
        Manager _manager = null;
//        if (user.isPresent()) {
//            log.info("Username already exists please choose another username");
//        } else
        {
            Manager manager = new Manager();
            manager.setFirstName(firstName);
            manager.setLastName(lastName);
            manager.setEmail(email);
            manager.setPhone(phone);
            manager.setAddress(address);
            manager.setGender(gender);
            manager.setUsername(username);
            manager.setPassword(password);
            manager.setRole("ROLE_MANAGER");
            manager.setActive(true);
            _manager = this.create(manager);
        }
        return _manager;
    }
        public Manager create(Manager manager){
            return managerRepository.save(manager);
    }
    public void delete(Manager manager){
        managerRepository.delete(manager);
        log.info("Manager account deleted..");
    }
    public Manager update(Manager manager){
       return managerRepository.save(manager);
    }
}
