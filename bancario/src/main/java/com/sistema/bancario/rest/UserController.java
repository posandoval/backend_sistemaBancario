package com.sistema.bancario.rest;

import com.sistema.bancario.entity.User;
import com.sistema.bancario.repository.UserRepository;
import com.sistema.bancario.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;
    Logger logg=LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService=userService;
    }

   @GetMapping("test")
   public  ResponseEntity<String> test(){
        return ResponseEntity.ok("testRest");
   }

    @PostMapping("create")
    public ResponseEntity<User> create(@RequestBody User user){

       /* if(user.getId()!=null || userService.getUser(user.getId()).isPresent()){
            logg.warn("Trying to creat user with id or user is present");
            return ResponseEntity.badRequest().build();
        }*/
        logg.info("User Created");
        User userTemp=userService.saveUser(user);
        return ResponseEntity.ok(userTemp);
    }

}//end class
