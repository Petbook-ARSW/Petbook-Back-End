package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRaffleRepo extends JpaRepository<Raffle,Integer> {
}
