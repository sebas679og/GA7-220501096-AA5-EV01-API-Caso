package com.sagmade.api_usuarios.controller;

import com.sagmade.api_usuarios.model.User;
import com.sagmade.api_usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.registerUser(user)) {
            return ResponseEntity.ok("Usuario registrado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: El usuario ya existe");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userService.authenticate(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok("Autenticación satisfactoria");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error en la autenticación");
        }
    }
}
