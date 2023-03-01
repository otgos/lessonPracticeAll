package com.alibaba.service;

import com.alibaba.entity.Brand;
import com.alibaba.entity.ContactMessage;
import com.alibaba.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage addMessage(ContactMessage contactMessage){
        return contactMessageRepository.save(contactMessage);
    }

    public List<ContactMessage> getAllMessages() {
        List<ContactMessage> getMessages = contactMessageRepository.findAll();
        return getMessages;
    }

    public ContactMessage getMessageById(Long messageId) {
        return contactMessageRepository.findById(messageId).orElseThrow();
    }

    public ContactMessage updateMessage(ContactMessage message, Long id){
        ContactMessage foundMessage = contactMessageRepository.findById(id).orElseThrow();

        foundMessage.setSubject(message.getSubject());
        foundMessage.setBody(message.getBody());
        foundMessage.setEmail(message.getEmail());

        return contactMessageRepository.save(foundMessage);

    }

    public void deleteById(Long messageId){
        contactMessageRepository.deleteById(messageId);
    }

}
