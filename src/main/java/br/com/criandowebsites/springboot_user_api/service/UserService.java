package br.com.criandowebsites.springboot_user_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.criandowebsites.springboot_user_api.model.User;
import br.com.criandowebsites.springboot_user_api.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
