package com.example.service;

import com.example.entity.Account;
import com.example.entity.Message;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    @Autowired 
    private AccountRepository accountRepository;

    public ResponseEntity<?> createMessage(Message message) {
        // if the messageText is not blank, is not over 255 characters, and postedBy refers to a real, existing user

        // Check for message requirements

        Optional<Account> postedBy = accountRepository.findById(message.getPostedBy());

        if (message.getMessageText().isEmpty() || message.getMessageText().length() > 255 || postedBy.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid message"); // 400 error code

        }

        Message savedMessage = messageRepository.save(message);

        return ResponseEntity.ok(savedMessage);
    }

    public ResponseEntity<?> getAllMessages() {

        return ResponseEntity.ok(messageRepository.findAll());
    }

    public ResponseEntity<?> getMessageById(Integer message_id) {

        if (messageRepository.existsById(message_id)) {
        
            return ResponseEntity.ok(messageRepository.findById(message_id));
        }

        return ResponseEntity.ok("");
    }

    public ResponseEntity<?> deleteMessageById(Integer message_id) {

        if (messageRepository.existsById(message_id)) {
            messageRepository.deleteById(message_id);
            return ResponseEntity.ok("1");
        }

        return ResponseEntity.ok("");
    }

    public ResponseEntity<?> updateMessageById(Message newMessage, Integer message_id) {
        //  the message id already exists and the new messageText is not blank and is not over 255 characters.

        if (messageRepository.existsById(message_id)) {
            if (!newMessage.getMessageText().isEmpty() && newMessage.getMessageText().length() < 255) {
                return ResponseEntity.ok("1");
    
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("Invalid message"); // 400 error code
    }

    public ResponseEntity<?> getAllMessagesByAccountId(Integer account_id) {
        return ResponseEntity.ok(messageRepository.findByPostedBy(account_id));
    }

}
