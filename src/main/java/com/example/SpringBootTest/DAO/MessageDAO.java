package com.example.SpringBootTest.DAO;

import com.example.SpringBootTest.repository.MessageRepo;
import com.example.SpringBootTest.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageDAO {
    @Autowired
    private MessageRepo messageRepo;

    public Message saveMessage(Message message)
    {
        return messageRepo.save(message);
    }

    public List<Message> getAllMessages()
    {
        List<Message> messages = new ArrayList<>();
        Streamable.of(messageRepo.findAll()).forEach(messages::add);
        return messages;
    }

    public void deleteMessage(Message message)
    {
        messageRepo.delete(message);
    }
    public List<Message> findSenderID(int senderId)
    {
        List<Message> allMessages = getAllMessages();
        List<Message> result = new ArrayList<>();
        for(Message messages: allMessages)
        {
            if(messages.getSender() == senderId)
            {
                result.add(messages);
            }
        }

        return result;
    }

}
