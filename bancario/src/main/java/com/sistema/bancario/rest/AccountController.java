package com.sistema.bancario.rest;

import com.sistema.bancario.entity.Account;
import com.sistema.bancario.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("create")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        Account accountTemp= accountService.saveAccount(account);
        return ResponseEntity.ok(accountTemp);
    }

    @GetMapping("get/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountNumber){

        Account accountTemp=accountService.getAccount(accountNumber);
        return ResponseEntity.ok(accountTemp);
    }

    @DeleteMapping("delete/{accountNumber}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Long accountNumber){
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.noContent().build();
    }

}
