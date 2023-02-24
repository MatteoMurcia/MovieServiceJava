package com.example.demo.controller;

import com.example.demo.controller.dto.privateDTO;
import com.example.demo.controller.dto.userDTO;
import com.example.demo.model.User;
import com.example.demo.model.movie;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {
    @PostMapping("/public")
    public List<movie> getAllPublic() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<movie> movies = objectMapper.readValue(new File("src/main/java/com/example/demo/controller/movies.json"), new TypeReference<List<movie>>(){});
        List<movie> publicMovies = new ArrayList<movie>();

        for(movie m : movies){
            if(m.getObjectType().equals("public")){
                publicMovies.add(m);
            }
        }

        return publicMovies;
    }

    @PostMapping("/private")
    public List<movie> getAllprivate(@RequestBody privateDTO dto) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<movie> movies = objectMapper.readValue(new File("src/main/java/com/example/demo/controller/movies.json"), new TypeReference<List<movie>>(){});
        List<movie> privateMovies = new ArrayList<movie>();

        for(movie m : movies){
            if(m.getObjectType().equals("private") && m.getEmail().equals(dto.getEmail())){
                privateMovies.add(m);
            }
        }

        return privateMovies;
    }
}
