package ProjektiProve.service;

import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.dto.ShipDTO;
import ProjektiProve.model.Passenger;

import java.util.List;

public interface PassengerService {



    PassengerDTO registerPassenger(PassengerDTO req,Integer shipId);

    Passenger findById(Integer id );

    PassengerDTO updatePassenger(Integer id , PassengerDTO req);


    List<PassengerDTO> findALL ();

    Void deltePassengerById (Integer id);


}
