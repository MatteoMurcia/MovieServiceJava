package com.example.demo.controller;

import com.example.demo.controller.dto.TokenDTO;
import com.example.demo.controller.dto.userDTO;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DemoController {

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody userDTO dto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = objectMapper.readValue(new File("src/main/java/com/example/demo/controller/users.json"), new TypeReference<List<User>>(){});

        if(!isValidEmail(dto.getEmail())) {
            return ResponseEntity.badRequest().body("Invalid email format");
        }

        for (User user : users) {
            if (user.getEmail().equals(dto.getEmail())) {
                return ResponseEntity.badRequest().body("Email already registered");
            }
        }

        // validate password
        if(!isValidPassword(dto.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password format");
        }


        users.add(new User(dto.getEmail(),dto.getPassword()));
        objectMapper.writeValue(new File("src/main/java/com/example/demo/controller/users.json"), users);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody userDTO dto) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = objectMapper.readValue(new File("src/main/java/com/example/demo/controller/users.json"), new TypeReference<List<User>>(){});

        User temp = new User();
        for (User user : users) {
            if (user.getEmail().equals(dto.getEmail())) {
                temp = user;
            }
        }

        String token = generateToken(temp.getEmail());
        return ResponseEntity.ok(new TokenDTO(token));

    }

    private boolean isValidEmail(String email) {
        // validate email format
        return EmailValidator.getInstance().isValid(email);
    }


    private boolean isValidPassword(String password) {
        // validate password format
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{10,}$";
        return password.matches(regex);
    }

    private String generateToken(String email) {
        // generate token using JWT
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(email);
        builder.setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000));
        builder.signWith(SignatureAlgorithm.HS256, "shhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" );// 20 minutes
        return builder
                .compact();
    }

}
