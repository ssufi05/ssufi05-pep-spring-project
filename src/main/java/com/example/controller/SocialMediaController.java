package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Account;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 /**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 * 
 * The included endpoints:
 * 
 * POST localhost:8080/register : Create a new Account
 * POST localhost:8080/login : Verify login
 * POST localhost:8080/messages : Submit a new post
 * GET localhost:8080/messages : Retrieve all messages
 * GET localhost:8080/messages/{message_id} : Retrieve message by ID
 * DELETE localhost:8080/messages/{message_id} : Delete message by ID
 * PATCH localhost:8080/messages/{message_id} : Update a message
 * GET localhost:8080/accounts/{account_id}/messages : Retrieve all messages written by a user
 * 
 */


@RestController
public class SocialMediaController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/register")
    Public ResponseEntity<String> registerAccount(@RequestBody Account account) {
        // Delegate to the Service Layer
        String result = accountService.registerAccount(account);
    }
    

    @PostMapping("/login")
    Public User login(@RequestBody Account)

    @PostMapping("/messages")

    @GetMapping("/messages")

    @GetMapping("/messages/{message_id}")

    @DeleteMapping("messages/{message_id}")

    @PatchMapping("/messages/{message_id}")

    @GetMapping("/accounts/{account_id}")

}
