package ProjektiProve.mapper;

import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.model.Passenger;
import ProjektiProve.model.Ship;

public class PassengerMapper {

    public static PassengerDTO toDTO(Passenger p){
        return PassengerDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                .build();
    }

    public static Passenger toEntity(PassengerDTO p ){

        Passenger build = Passenger.builder()
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                .shipID(p.getShip()!= null?p.getShip():null)
                .build();
        return build;


    }

    public static Passenger toAddforEntity(PassengerDTO passengerDTO, Integer shipId) {
        return Passenger.builder()
                .id(passengerDTO.getId())
                .name(passengerDTO.getName())
                .surname(passengerDTO.getSurname())
                .age(passengerDTO.getAge())
                .shipID(Ship.builder()
                        .id(shipId)
                        .build())
                .build();

    }


    public static PassengerDTO toUpdateDto (Passenger p ){
        return PassengerDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                //.shipidDTO(p.getId())

                .build();

    }
    public static Passenger buildUpdatePassenger(Passenger p , PassengerDTO req){
        p.setName(req.getName());
        p.setSurname(req.getSurname());
        p.setAge(req.getAge());
        //p.setId();

        return p;

    }

}
