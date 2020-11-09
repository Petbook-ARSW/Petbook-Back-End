package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepo extends JpaRepository<Notification, Integer> {
}
