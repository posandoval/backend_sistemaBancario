package com.sistema.bancario.services.impl;

import com.sistema.bancario.entity.User;
import com.sistema.bancario.repository.UserRepository;
import com.sistema.bancario.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl1 implements UserService {

    private UserRepository userRepository;

    //Reemplaza al autowired
    public UserServiceImpl1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User userTemp = userRepository.save(user);
        return userTemp;
    }

    @Override
    public Optional<User> getUser(Long id) {
        Optional<User> userTemp = userRepository.findById(id);
        return userTemp;
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        }
        catch(Exception e){

        }
    }
}
