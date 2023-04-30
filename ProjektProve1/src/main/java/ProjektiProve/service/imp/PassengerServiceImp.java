package ProjektiProve.service.imp;

import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.exception.ResourceNotFountException;
import ProjektiProve.mapper.PassengerMapper;
import ProjektiProve.model.Passenger;
import ProjektiProve.repository.PassengerRepositoty;
import ProjektiProve.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class PassengerServiceImp implements PassengerService {


    private final PassengerRepositoty passengerRepositoty;

    @Override
    public PassengerDTO registerPassenger(PassengerDTO req ) {
        Passenger p = PassengerMapper.toEntity(req);
        if (p.getId()==null)
            p = passengerRepositoty.save(p);
        return PassengerMapper.toDTO(p);
    }

    @Override
    public Passenger findById(Integer id) {
        return passengerRepositoty.findById(id)
                .orElseThrow(()->new ResourceNotFountException(String
                        .format("User with id%s not found" , id)));
    }

    @Override
    public PassengerDTO updatePassenger(Integer id, PassengerDTO req) {
       Passenger p = findById(id);
       p = PassengerMapper.buildUpdatePassenger(p , req );
       return PassengerMapper.toUpdateDto(passengerRepositoty.save(p));
    }

    @Override
    public List<PassengerDTO> findALL() {

        return passengerRepositoty.findAll()
                .stream()
                .map(PassengerMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public Void deltePassengerById(Integer id) {
        Passenger p = passengerRepositoty.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(
                        String.format("passenger with id %s not found",id)));
        passengerRepositoty.delete(p);
        return null;
    }
}
