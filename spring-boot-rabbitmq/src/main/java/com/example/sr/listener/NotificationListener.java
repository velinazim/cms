package com.example.sr.listener;

import com.example.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "veli-nazim-queue")
    public void handleMassage(Notification notification){
        System.out.println("Mesaj Alindi");
        System.out.println(notification.toString());
    }
}
