package com.example.demobnabd.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }
    @GetMapping(value = "/{accountId}")
    public Optional<Account> getId(@PathVariable("accountId") Long accountId){
        return accountService.findById(accountId);
    }
    @PostMapping("/account")
    public Account addAccount(@RequestBody Account account){
        return accountService.save(account);
    }
    @PutMapping(path = "{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable("accountId") Long accountId, @RequestBody Account updatedAccount){
        Optional<Account> accountOptional = accountService.findById(accountId);

        if (accountOptional.isPresent()) {
            Account existingAccount = accountOptional.get();
            existingAccount.setEnabled(updatedAccount.isEnabled());
            existingAccount.setLogin(updatedAccount.getLogin());
            existingAccount.setPassword(updatedAccount.getPassword());
            existingAccount.setRole(updatedAccount.getRole());

            accountService.save(existingAccount);
            return ResponseEntity.ok("Account with ID " + accountId + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{accountId}")
    public void deleteAccount(@PathVariable("accountId") Long accountId){
        accountService.deleteById(accountId);
    }
}