package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 /**
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
    public ResponseEntity<?> registerAccount(@RequestBody Account account) {
        // Delegate to the Service Layer
        return accountService.registerAccount(account);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@RequestBody Account account) {
        // Delegate to the Service Layer
        return accountService.loginAccount(account);
    }

    @PostMapping("/messages")
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        // Delegate to the Service Layer
        return messageService.createMessage(message);
    }

    @GetMapping("/messages")
    public ResponseEntity<?> getAllMessages() {
        // Delegate to the Service Layer
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{message_id}") 
    public ResponseEntity<?> getMessageById(@PathVariable("message_id") Integer messageId) {
        // Delegate to the Service Layer
        return messageService.getMessageById(messageId);
    }
    
    @DeleteMapping("messages/{message_id}")
    public ResponseEntity<?> deleteMessageById(@PathVariable("message_id") Integer messageId) {
        // Delegate to the Service Layer
        return messageService.deleteMessageById(messageId);
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<?> updateMessageById(@RequestBody Message newMessage, @PathVariable("message_id") Integer messageId) {
        // Delegate to the Service Layer
        return messageService.updateMessageById(newMessage, messageId);
    }

    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<?> getAllMessagesByAccount(@PathVariable("account_id") Integer accountId) {
        // Delegate to the Service Layer
        return messageService.getAllMessagesByAccountId(accountId);
    }

}
