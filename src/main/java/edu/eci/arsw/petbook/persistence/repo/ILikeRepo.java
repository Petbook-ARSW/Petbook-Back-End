package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepo  extends JpaRepository<Like, Integer> {
    
}
