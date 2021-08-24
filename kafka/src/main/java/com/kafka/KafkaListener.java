package com.kafka;


import com.kafka.dto.KMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group.id}"
    )
    public void listen(@Payload KMessage kMessage) {
        log.info("Message recieved.. MessageId: {} Message: {} Date: {}",
                kMessage.getId(),
                kMessage.getMessage(),
                kMessage.getMessageDate());
    }
}
