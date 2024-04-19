package com.example.demobnabd.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> findById(Long id){
        return accountRepository.findById(id);
    }
    public List<Account> findAll(){
        return accountRepository.findAll();
    }
    public Account save(Account account){
        return accountRepository.save(account);
    }
    public List<Account> saveAll(List<Account> accounts){
        return accountRepository.saveAll(accounts);
    }

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }
}
