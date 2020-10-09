package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IParticipantRepo extends JpaRepository<Participant, Integer> {
}
