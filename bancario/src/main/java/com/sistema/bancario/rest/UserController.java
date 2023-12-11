package com.sistema.bancario.rest;

import com.sistema.bancario.entity.User;
import com.sistema.bancario.repository.UserRepository;
import com.sistema.bancario.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("api/v1")
public class UserController {

private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("create")
    public ResponseEntity<User> create(@RequestBody User user){
        User userTemp=userService.saveUser(user);
        return ResponseEntity.ok(userTemp);
    }

}//end class
