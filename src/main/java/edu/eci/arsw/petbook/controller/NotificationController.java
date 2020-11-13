package edu.eci.arsw.petbook.controller;

import edu.eci.arsw.petbook.model.Notification;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @MessageMapping("/notification/{userId}")
    @SendTo("/topic/notification/{userId}")
    public Notification obtainNotification (@DestinationVariable int userId,  Notification notification){
        try {
            return notification;
        } catch (Exception e) {
            return null;
        }
    }

}
