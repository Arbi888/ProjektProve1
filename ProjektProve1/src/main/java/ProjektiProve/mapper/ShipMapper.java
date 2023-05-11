package ProjektiProve.mapper;

import ProjektiProve.dto.ShipDTO;

import ProjektiProve.model.Ship;

import java.util.stream.Collectors;

public class ShipMapper {


    public static ShipDTO toDTO(Ship sh){

        return ShipDTO.builder()
                .id(sh.getId())
                .name(sh.getName())
                .destination(sh.getDestination())
                .passengerList(sh.getPassengerList()!=null?sh.getPassengerList().stream().map(PassengerMapper::toDTO).collect(Collectors.toList()):null)
                .build();
    }


    public static Ship toEntity(ShipDTO sh){
      Ship build = Ship.builder()
              .name(sh.getName())
              .destination(sh.getDestination())
              .passengerList(sh.getPassengerList()!=null?sh.getPassengerList().stream().map(PassengerMapper::toEntity).collect(Collectors.toList()) : null)
              .build();
      return build;
    }

    public static ShipDTO toUpdateDto(Ship sh){
        return ShipDTO.builder()
                .id(sh.getId())
                .name(sh.getName())
                .destination(sh.getDestination())
                .build();
    }

    public static Ship buildUpdateShip(Ship sh, ShipDTO req){
        sh.setName(req.getName());
        sh.setDestination(req.getDestination());
        return sh;
    }





}
