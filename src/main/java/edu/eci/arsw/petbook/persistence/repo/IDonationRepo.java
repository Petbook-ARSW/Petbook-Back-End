package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonationRepo extends JpaRepository<Donation,Integer>{
    
}
