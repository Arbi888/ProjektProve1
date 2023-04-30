package ProjektiProve.service;

import ProjektiProve.dto.UserDTO;
import ProjektiProve.dto.UserUpdateDTO;
import ProjektiProve.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDTO registerUser(UserDTO req);
    User findById(Integer id);

    UserUpdateDTO updateUser(Integer id, UserUpdateDTO req);

    Void deleteUserById(Integer id);





}
