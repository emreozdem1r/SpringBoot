package com.aspect.example.api;


import com.aspect.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;


    @PostMapping
    ResponseEntity<String> messageController(@RequestBody String message) {
        return ResponseEntity.ok(messageService.giveMessage(message));
    }
}
