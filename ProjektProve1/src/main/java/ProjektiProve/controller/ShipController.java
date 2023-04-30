package ProjektiProve.controller;


import ProjektiProve.dto.ShipDTO;
import ProjektiProve.mapper.ShipMapper;
import ProjektiProve.model.Ship;
import ProjektiProve.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ships")
public class ShipController {

    @Autowired
    private ShipService shipService;

    @PostMapping("/register")
    public ResponseEntity<ShipDTO> registerShip(@RequestBody @Valid ShipDTO sh){
        return ResponseEntity.ok(shipService.registerShip(sh));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ShipDTO> updateShip (@PathVariable Integer id ,
                                               @Valid @RequestBody ShipDTO req){
      ShipDTO sh = shipService.updateShip(id,req);
        return ResponseEntity.ok(sh);
    }

    @GetMapping("/find/{shipid}")
    public ResponseEntity<ShipDTO> findById (@PathVariable Integer shipid){
        Ship sh = shipService.findById(shipid);
        return ResponseEntity.ok(ShipMapper.toDTO(sh));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteshipbyid(@PathVariable Integer id){
        return ResponseEntity.ok(shipService.deleteshipbyid(id));
    }

}
