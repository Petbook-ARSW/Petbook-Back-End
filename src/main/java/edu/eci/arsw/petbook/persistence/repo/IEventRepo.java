package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepo extends JpaRepository<Event,Integer> {
}
