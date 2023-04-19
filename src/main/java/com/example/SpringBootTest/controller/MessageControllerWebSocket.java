package com.example.SpringBootTest.controller;

import com.example.SpringBootTest.DAO.MessageDAO;
import com.example.SpringBootTest.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MessageControllerWebSocket {
    @Autowired
    MessageDAO messageDAO;
    Message message;
//
//    @GetMapping("/message/get")
//    public List<Message> getAllMessages() {
//        return messageDAO.getAllMessages();
//    }
//
//    @PostMapping("/message/save")
//    public Message save(@RequestBody Message message) {
//        return messageDAO.saveMessage(message);
//    }

    @MessageMapping("/message/{senderID}/{senderName}")
    @SendTo("/topics/event/public")
    public List<Message> getChat(String content, @DestinationVariable int senderID, @DestinationVariable String senderName)
    {
        messageDAO.saveMessage(new Message(senderID ,senderName, content));
        return messageDAO.getAllMessages();
    }

    @MessageMapping("/message/{senderID}/listen")
    @SendTo("/topics/event/public")
    public List<Message> subscribeToMessage(@DestinationVariable int senderID)
    {
        return messageDAO.findSenderID(senderID);
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        message = "Hello";
        Thread.sleep(1000); // simulated delay
        return message;
    }

}
