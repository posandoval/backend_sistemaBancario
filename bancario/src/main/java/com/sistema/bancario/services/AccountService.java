package com.sistema.bancario.services;

import com.sistema.bancario.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

public Account saveAccount(Account account);
public Account getAccount(Account account);
public void deleteAccount(Long id);

}
