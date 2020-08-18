package com.example.Api;

import com.example.entity.Users;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersApi {
    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void init(){
        Users users = new Users();
        users.setName("Veli Nazım");
        users.setLast_name("Akyıldırım");
        usersRepository.save(users);

    }

    @PostMapping
    public ResponseEntity<Users> add(@RequestBody Users users){
        return ResponseEntity.ok(usersRepository.save(users));
    }

    @GetMapping
    public ResponseEntity<List<Users>> AllUsers(){
        return ResponseEntity.ok(usersRepository.findAll());
    }
}
