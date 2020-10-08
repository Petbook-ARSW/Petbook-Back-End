package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGoalRepo extends JpaRepository<Goal,Integer> {
}
