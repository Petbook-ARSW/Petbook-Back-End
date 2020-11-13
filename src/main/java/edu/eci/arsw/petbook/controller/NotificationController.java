package edu.eci.arsw.petbook.controller;

import edu.eci.arsw.petbook.model.Notification;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class NotificationController {

    @MessageMapping("/notification")
    @SendTo("/topic/notification")
    public Notification obtainNotification (Notification notification){
        try {
            return notification;
        } catch (Exception e) {
            return null;
        }
    }

}
