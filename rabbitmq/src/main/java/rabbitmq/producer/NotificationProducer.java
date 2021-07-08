package rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rabbitmq.model.Notification;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    public void sendToQueue(Notification notification) {
        System.out.println(routingName);
        System.out.println("Notification send: " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }

    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("RabbitMQ message");
        notification.setSeen(false);

        this.sendToQueue(notification);
    }
}
