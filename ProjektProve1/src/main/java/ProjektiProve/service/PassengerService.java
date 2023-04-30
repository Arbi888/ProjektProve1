package ProjektiProve.service;

import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.model.Passenger;

import java.util.List;

public interface PassengerService {

    PassengerDTO registerPassenger  (PassengerDTO req);

    Passenger findById(Integer id );

    PassengerDTO updatePassenger(Integer id , PassengerDTO req);


    List<PassengerDTO> findALL ();


}
