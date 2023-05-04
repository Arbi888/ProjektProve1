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
               // .shipid(p.getId())
              //  .shipid(p.getShip().getId())

                .build();
    }

    public static Passenger toEntity(PassengerDTO p ){

        Passenger build=Passenger.builder()
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())

              //  .ship()
             //   .ship(p.getShipid())
               // .id(p.getShipid())

                .build();
        return build;


    }

    public static PassengerDTO toUpdateDto (Passenger p ){
        return PassengerDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())

             //   .shipid(p.getId())

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
