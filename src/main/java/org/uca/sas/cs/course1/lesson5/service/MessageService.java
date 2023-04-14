package org.uca.sas.cs.course1.lesson5.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.uca.sas.cs.course1.lesson5.mapper.MessageMapper;
import org.uca.sas.cs.course1.lesson5.model.Message;
import org.uca.sas.cs.course1.lesson5.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private MessageMapper  messageMapper;
    private List<Message> messages;
    private Integer lastMessageId;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
        this.messages = new ArrayList<>();
    }

    public String getCurrentUsername() {
        String username = null;

        // retrieving the current user
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public List<Message> getMessages() {
        return messageMapper.getMessages(getCurrentUsername());
    }

    public void addMessage(Message message) {
//        messages.add(message);
        lastMessageId = messageMapper.insert(new Message(null, getCurrentUsername(), message.getMessagetext()));
    }
}
