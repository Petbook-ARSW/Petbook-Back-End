package edu.eci.arsw.petbook.controller;

import edu.eci.arsw.petbook.model.Notification;
import edu.eci.arsw.petbook.service.IDonationServices;
import edu.eci.arsw.petbook.service.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @Autowired
    IUserServices us;

    @Autowired
    IDonationServices ds;

    @MessageMapping("/notification/{userId}")
    @SendTo("/topic/notification/{userId}")
    public Notification obtainNotification (@DestinationVariable int userId,  Notification notification){
        try {
            us.addNotification(notification);
            return notification;
        } catch (Exception e) {
            return null;
        }
    }

}
