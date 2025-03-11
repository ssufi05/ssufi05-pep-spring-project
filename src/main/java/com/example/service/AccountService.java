package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<?> registerAccount(Account account) {

        // Check if username is blank
        if (account.getUsername() == null || account.getUsername() == "") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid username"); // 400 error code
        }

        // Check password length
        if (account.getPassword().length() < 4) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid password"); // 400 error code

        }

        // Check if username already exists
        if (accountRepository.findByUsername(account.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Username already exists"); // 409 error code

        }

        Account savedAccount = accountRepository.save(account);

        return ResponseEntity.ok(savedAccount);

    }

    public ResponseEntity<?> loginAccount(Account account) {

        Optional<Account> optionalLoginAccount = accountRepository.findByUsername(account.getUsername());

        // Check if username is blank
        if (optionalLoginAccount.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password"); // 401 unathorized code
        }

        Account loginAccount = optionalLoginAccount.get();

        if (!loginAccount.getPassword().equals(account.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password"); // 401 unathorized code
        }

        return ResponseEntity.ok(loginAccount);

    }

}
