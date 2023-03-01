package com.alibaba.controller;

import com.alibaba.entity.ContactMessage;
import com.alibaba.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class ContactMessageController {
    @Autowired
    private ContactMessageService contactMessageService;



    //http://localhost:8082/message/addmessage
    @PostMapping("/addmessage")
    public ResponseEntity<ContactMessage> addMessage(@RequestBody ContactMessage contactMessage){
        ContactMessage createdMessage = contactMessageService.addMessage(contactMessage);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<ContactMessage>> getALlMessages() {
        List<ContactMessage> contactMessageList = contactMessageService.getAllMessages();
        return new ResponseEntity<>(contactMessageList, HttpStatus.OK);
    }

    @GetMapping("/getMessageById/{messageId}")
    public ResponseEntity<ContactMessage> getContanctMessageById(@PathVariable("messageId") Long messageId) {
        ContactMessage contactMessage = contactMessageService.getMessageById(messageId);
        return new ResponseEntity<>(contactMessage, HttpStatus.OK);
    }


    @PutMapping ("/updateMessage/{id}")
    public ResponseEntity<ContactMessage> updateMessage(@RequestBody ContactMessage message, @PathVariable("id") Long id) {
        ContactMessage updatedMessage = contactMessageService.updateMessage(message, id);
        return new ResponseEntity<>(updatedMessage, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{Id}")
    public ResponseEntity<String> deletedMessage(@PathVariable("Id")Long Id){
        contactMessageService.deleteById(Id);
        return new ResponseEntity<>("Message was deleted succesfully", HttpStatus.OK);
    }





}
