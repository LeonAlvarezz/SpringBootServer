package com.example.SpringBootTest.controller;

import com.example.SpringBootTest.DAO.MessageDAO;
import com.example.SpringBootTest.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MessageController {
        @Autowired
        MessageDAO messageDAO;
        Message message;

        @GetMapping("/message/get")
        public List<Message> getAllMessages() {
            return messageDAO.getAllMessages();
        }
        @PostMapping("/message/save")
        public Message save(@RequestBody Message message) {
            return messageDAO.saveMessage(message);
    }
}
