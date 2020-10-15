package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepo  extends JpaRepository<Pet,Integer> {
}
