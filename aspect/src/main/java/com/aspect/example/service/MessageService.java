package com.aspect.example.service;


import org.springframework.stereotype.Service;

@Service
public class MessageService {


    public String giveMessage(String message) {
        System.out.println("method gave a message: " + message);

        return message;
    }
}
