package ProjektiProve.mapper;

import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.model.Passenger;

public class PassengerMapper {

    public static PassengerDTO toDTO(Passenger p ){
        return PassengerDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                .build();
    }

    public static Passenger toEntity(PassengerDTO p ){

        Passenger build=Passenger.builder()
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                .build();
        return build;

    }

    public static PassengerDTO toUpdateDto (Passenger p ){
        return PassengerDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                .build();

    }
    public static Passenger buildUpdatePassenger(Passenger p , PassengerDTO req){
        p.setName(req.getName());
        p.setSurname(req.getSurname());
        p.setAge(req.getAge());
        return p;

    }

}