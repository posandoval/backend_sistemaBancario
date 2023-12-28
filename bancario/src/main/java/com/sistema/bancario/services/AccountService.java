package com.sistema.bancario.services;

import com.sistema.bancario.entity.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AccountService {

Account saveAccount(Account account);
Optional<Account> getAccount(Long accountNumber);
void deleteAccount(Long accountNumber);

Account retirar(Long accountNumber,Double monto);
Account depositar(Long accountNumber, Double monto);

String tranferir(Long accountNumberOut,Long accountNumberIn,Double monto);
}
