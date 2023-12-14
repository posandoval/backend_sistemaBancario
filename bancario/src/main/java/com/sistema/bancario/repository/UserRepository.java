package com.sistema.bancario.repository;

import com.sistema.bancario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByDNI(Long DNI);
}
