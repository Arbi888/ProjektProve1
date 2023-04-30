package ProjektiProve.repository;

import ProjektiProve.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepositoty extends JpaRepository <Passenger , Integer> {
}
