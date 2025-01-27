package dev.ali.pos.service;

import dev.ali.pos.entity.Admin;
import dev.ali.pos.entity.User;
import dev.ali.pos.repository.AdminRepository;
import dev.ali.pos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private static final Logger log = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;


    public Admin create(String firstName, String lastName, String phone, String username, String password) {
        log.info("First name -> "+firstName+" Last name -> "+lastName+" username -> "+username);
//        Optional<User> user = userRepository.findByUsername(username);
        Admin _admin = null;
//        if (user.isPresent()) {
//            log.info("Username already exists please choose another username");
//        } else
        {
            Admin admin = new Admin();
            admin.setFirstName(firstName);
            admin.setLastName(lastName);
            admin.setPhone(phone);
            admin.setUsername(username);
            admin.setPassword(password);
            admin.setRole("ROLE_ADMIN");
            admin.setActive(true);
            _admin = this.create(admin);
        }
        return _admin;
    }
    public Admin create(Admin admin){
        return adminRepository.save(admin);
    }
    public void delete(Admin admin){
        adminRepository.delete(admin);
        log.info("Admin account deleted..");
    }
    public Admin update(Admin admin){
        return adminRepository.save(admin);
    }
}
