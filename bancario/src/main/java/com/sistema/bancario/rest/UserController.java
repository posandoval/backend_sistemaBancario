package com.sistema.bancario.rest;

import com.sistema.bancario.entity.User;
import com.sistema.bancario.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;
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
       if(userService.validUser(user)){
            logg.warn("Trying to create a existent user");
            return ResponseEntity.badRequest().build();
        }
       else {
           logg.info("User Created");
           User userTemp = userService.createUser(user);
           return ResponseEntity.ok(userTemp);
       }
    }

    @GetMapping("validar")
    public Boolean validarUser(@RequestBody User user){
        return userService.validUser(user);
    }

 }//end class
