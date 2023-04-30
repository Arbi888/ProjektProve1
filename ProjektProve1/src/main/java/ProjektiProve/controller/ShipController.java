package ProjektiProve.controller;


import ProjektiProve.dto.ShipDTO;
import ProjektiProve.dto.UserDTO;
import ProjektiProve.dto.UserUpdateDTO;
import ProjektiProve.mapper.ShipMapper;
import ProjektiProve.mapper.UserMapper;
import ProjektiProve.model.Ship;
import ProjektiProve.model.User;
import ProjektiProve.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ships")
public class ShipController {

    private ShipService shipService;

    @PostMapping("/register/{shipid}")
    public ResponseEntity<ShipDTO> registerShip(@PathVariable Integer shipId,
                                                @Valid @RequestBody ShipDTO sh){
        return ResponseEntity.ok(shipService.registerShip(sh));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ShipDTO> updateShip (@PathVariable Integer shipid ,
                                               @Valid @RequestBody ShipDTO req){
      ShipDTO sh = shipService.updateShip(shipid,req);
        return ResponseEntity.ok(sh);
    }

    @GetMapping("/find/{shipid}")
    public ResponseEntity<ShipDTO> findById (@PathVariable Integer shipid){
        Ship sh = shipService.findById(shipid);
        return ResponseEntity.ok(ShipMapper.toDTO(sh));
    }


}
