package com.sistema.bancario.services;

import com.sistema.bancario.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    public User saveUser(User user);
    public User getUser(Long id);
    public void deleteUser(Long id);


}
