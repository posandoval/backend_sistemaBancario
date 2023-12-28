package com.sistema.bancario.rest;

import com.sistema.bancario.entity.Account;
import com.sistema.bancario.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("Account")
@RequiredArgsConstructor
public class AccountController {

    private final Logger logger= LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;


    @PostMapping("create")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        Account accountTemp= accountService.saveAccount(account);
        return ResponseEntity.ok(accountTemp);
    }

    @GetMapping("get/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountNumber){
        Optional<Account> accountTemp=accountService.getAccount(accountNumber);
        if(!accountTemp.isPresent()){
            logger.warn("Account Number not found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountTemp.get());
    }

    @DeleteMapping("delete/{accountNumber}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Long accountNumber){
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("retiro/{accountNumber},{monto}")
    public ResponseEntity<Account> retirar(@PathVariable Long accountNumber,@PathVariable Double monto){
        return ResponseEntity.ok(accountService.retirar(accountNumber,monto));
    }

    @PutMapping("deposito/{accountNumber},{monto}")
    public ResponseEntity<Account> depositar(@PathVariable Long accountNumber, @PathVariable Double monto){

       return ResponseEntity.ok(accountService.depositar(accountNumber,monto));

    }

    @PutMapping("transferir/{accountNumberOut},{accountNumberIn},{monto}")
    public ResponseEntity<String> transferir(@PathVariable Long accountNumberOut,@PathVariable Long accountNumberIn, @PathVariable Double monto){

       String response= accountService.tranferir(accountNumberOut,accountNumberIn,monto);

        return ResponseEntity.ok(response);
    }


}//endClass