package dev.ali.pos.service;

import dev.ali.pos.entity.User;
import dev.ali.pos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        log.info("Checking if username already exists...");
        Optional<User> _user = this.findByUsername(user.getUsername());
        if(_user.isPresent()){
            log.info("Creating new user...");
            return userRepository.save(user);
        }
        else return null;
    }
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
