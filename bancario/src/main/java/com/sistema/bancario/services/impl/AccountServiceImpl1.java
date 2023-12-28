package com.sistema.bancario.services.impl;

import com.sistema.bancario.entity.Account;
import com.sistema.bancario.repository.AccountRepository;
import com.sistema.bancario.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl1 implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccount(Long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        try {
            accountRepository.deleteById(accountNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Account retirar(Long accountNumber, Double monto){
        //get Account
        Optional<Account> temp=accountRepository.findByAccountNumber(accountNumber);

        //retiro
        Double newBalance=temp.get().getBalance()-monto;

        //set NewBalance
        temp.get().setBalance(newBalance);

        return accountRepository.save(temp.get());
    }

    @Override
    public Account depositar(Long accountNumber, Double monto) {
        //GetAccount
        Optional<Account> tempAccount=accountRepository.findByAccountNumber(accountNumber);

        //deposito
        Double newBalance=tempAccount.get().getBalance()+monto;
        tempAccount.get().setBalance(newBalance);

        //save upDate Account
        return accountRepository.save(tempAccount.get());
    }

    @Override
    public String tranferir(Long accountNumberOut, Long accountNumberIn, Double monto) {

        //getAccountOut
        Optional<Account> accountOut=accountRepository.findByAccountNumber(accountNumberOut);
        //getAccountIn
        Optional<Account> accountIn=accountRepository.findByAccountNumber(accountNumberIn);

        //tranferencia
        Double balanceOut=accountOut.get().getBalance()-monto;
        Double balanceIn=accountIn.get().getBalance()+monto;

        accountOut.get().setBalance(balanceOut);
        accountIn.get().setBalance(balanceIn);

        //save transfer
        accountRepository.save(accountOut.get());
        accountRepository.save(accountIn.get());

        return "Transferencia Existosa";
    }


}//end class
