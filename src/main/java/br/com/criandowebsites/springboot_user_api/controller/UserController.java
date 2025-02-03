package br.com.criandowebsites.springboot_user_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandowebsites.springboot_user_api.dto.UserDTO;
import br.com.criandowebsites.springboot_user_api.model.User;
import br.com.criandowebsites.springboot_user_api.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User>createUser(@Valid @RequestBody  UserDTO userDTO) {
    	return new ResponseEntity<>(this.userService.createUser(userDTO), HttpStatus.CREATED);        
    }
}
