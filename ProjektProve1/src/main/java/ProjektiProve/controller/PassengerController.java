package ProjektiProve.controller;


import ProjektiProve.dto.PassengerDTO;
import ProjektiProve.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private PassengerService passengerService ;

    @PostMapping("/register/{passengerid}")
    public ResponseEntity<PassengerDTO> registerPassenger (@PathVariable Integer passengerid,
                                                           @Valid @RequestBody PassengerDTO p) {
        return ResponseEntity.ok(passengerService.registerPassenger(p));
    }




}
