package edu.eci.arsw.petbook.controllers;

import edu.eci.arsw.petbook.model.Notification;
import edu.eci.arsw.petbook.services.IUserServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*")
public class NotificationsController {

    @Autowired
    IUserServices us;

    @MessageMapping("/notification")
    @SendTo("/topic/notification")
    public Notification obtainNotification (Notification notification){
        try {
            us.addNotification(notification);
            return notification;
        } catch (PetbookServicesException e) {
            return null;
        }
    }

}
