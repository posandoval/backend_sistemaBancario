package com.sistema.bancario.services.impl;

import com.sistema.bancario.entity.Account;
import com.sistema.bancario.repository.AccountRepository;
import com.sistema.bancario.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl1 implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long accountNumber) {
        Account accountTemp=accountRepository.findByAccountNumber(accountNumber);
        return accountTemp;
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        try {
            accountRepository.deleteById(accountNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
