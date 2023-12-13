package com.sistema.bancario.services;

import com.sistema.bancario.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    public User saveUser(User user);
    public Optional<User> getUser(Long id);
    public void deleteUser(Long id);


}
