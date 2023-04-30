package ProjektiProve.service;

import ProjektiProve.dto.ShipDTO;
import ProjektiProve.dto.UserDTO;
import ProjektiProve.dto.UserUpdateDTO;
import ProjektiProve.model.Ship;
import ProjektiProve.model.User;

public interface ShipService {


    ShipDTO registerShip(ShipDTO req);

    Ship findById(Integer id);

    ShipDTO updateShip(Integer id, ShipDTO req);

    Void deleteshipbyid(Integer id);



}
