package com.sistema.bancario.services.impl;

import com.sistema.bancario.entity.User;
import com.sistema.bancario.repository.UserRepository;
import com.sistema.bancario.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl1 implements UserService {

    private final UserRepository userRepository;
    private final Logger logg=LoggerFactory.getLogger(UserServiceImpl1.class);

    //Reemplaza al autowired
    public UserServiceImpl1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

 @Override
   public User createUser(User user) {
     return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    //Metodo para validar si existe un useario a traves del id
    @Override
    public Boolean validUser(User user) {
        return userRepository.existsById(user.getId());
    }


    @Override
    public void deleteUser(Long id) {
                   userRepository.deleteById(id);
        }
}
