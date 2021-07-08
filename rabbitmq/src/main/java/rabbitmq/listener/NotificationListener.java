package rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbitmq.model.Notification;

@Service
public class NotificationListener {

    @RabbitListener(queues = "rmq-queue")
    public void handleMessage(Notification notification) {
        System.out.println("message recieved");
        System.out.println(notification.toString());
    }
}
