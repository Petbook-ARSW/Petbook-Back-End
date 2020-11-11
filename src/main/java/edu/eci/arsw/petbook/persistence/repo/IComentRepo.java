package edu.eci.arsw.petbook.persistence.repo;


import edu.eci.arsw.petbook.model.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentRepo extends JpaRepository<Coment,Integer> {
}
