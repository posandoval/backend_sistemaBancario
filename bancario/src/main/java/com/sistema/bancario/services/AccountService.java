package com.sistema.bancario.services;

import com.sistema.bancario.entity.Account;
import org.springframework.stereotype.Service;

public interface AccountService {

Account saveAccount(Account account);
Account getAccount(Long accountNumber);
void deleteAccount(Long accountNumber);

}
