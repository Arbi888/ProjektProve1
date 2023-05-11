package ProjektiProve.controller;


import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.mapper.PassengerMapper;
import ProjektiProve.model.Passenger;
import ProjektiProve.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService ;

    @PostMapping("/register/{shipId}")
    public ResponseEntity<PassengerDTO> registerPassenger (@RequestBody @Valid PassengerDTO p,@PathVariable(name = "shipId") Integer shipId) {
        return ResponseEntity.ok(passengerService.registerPassenger(p,shipId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable Integer id ,
                                                        @Valid @RequestBody PassengerDTO req){
        PassengerDTO p = passengerService.updatePassenger(id,req);
        return ResponseEntity.ok(p);
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<PassengerDTO>> findALL (){
        return ResponseEntity.ok(passengerService.findALL());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PassengerDTO> findById(@PathVariable Integer id){
        Passenger p = passengerService.findById(id);
        return ResponseEntity.ok(PassengerMapper.toDTO(p));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deltePassengerById(@PathVariable Integer id){
        return  ResponseEntity.ok(passengerService.deltePassengerById(id));
    }

}
