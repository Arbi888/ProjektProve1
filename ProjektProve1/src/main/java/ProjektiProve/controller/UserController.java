package ProjektiProve.controller;

import ProjektiProve.dto.UserDTO;
import ProjektiProve.dto.UserUpdateDTO;
import ProjektiProve.mapper.UserMapper;
import ProjektiProve.model.User;
import ProjektiProve.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Validated
public class UserController {
@Autowired

    private UserService userService;

    @PostMapping("/admin/{userRole}")
    public ResponseEntity<UserDTO> registerUser(@RequestBody  UserDTO userDTO, @PathVariable String userRole){
        UserDTO dto = userService.registerUser(userDTO,userRole);
        return ResponseEntity.ok(dto);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable Integer id,
                                                    @Valid @RequestBody UserUpdateDTO req){
        UserUpdateDTO u = userService.updateUser(id,req);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable Integer id){
        User u = userService.findById(id);
        return ResponseEntity.ok(UserMapper.toDTO(u));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id){
         return ResponseEntity.ok(userService.deleteUserById(id));
        }


    }


    



