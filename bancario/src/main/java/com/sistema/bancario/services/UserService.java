package com.sistema.bancario.services;

import com.sistema.bancario.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {


    User createUser(User user);
    Optional<User> findById(Long id);
    Boolean validUser(User user);
    void deleteUser(Long id);


}
