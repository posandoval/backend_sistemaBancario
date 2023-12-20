package com.sistema.bancario.repository;

import com.sistema.bancario.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByAccountNumber(Long accountNumber);
    void deleteByAccountNumber(Long accountNumber);

}
