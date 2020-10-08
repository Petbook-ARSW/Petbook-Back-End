package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
}
