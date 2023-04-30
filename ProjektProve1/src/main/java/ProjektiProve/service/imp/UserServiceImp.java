package ProjektiProve.service.imp;

import ProjektiProve.dto.UserDTO;
import ProjektiProve.dto.UserUpdateDTO;
import ProjektiProve.exception.ResourceNotFountException;
import ProjektiProve.mapper.UserMapper;
import ProjektiProve.model.User;
import ProjektiProve.repository.UserRepository;
import ProjektiProve.service.UserService;
import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService {

     private final UserRepository userRepository;

     @Override
     public UserDTO registerUser(UserDTO req) {
        User u = UserMapper.toEntity(req);
        if (u.getId()==null)
            u = userRepository.save(u);
         return  UserMapper.toDTO(u);
    }

    @Override
    public User findById(Integer id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountException(String
                        .format("User with id %s not found" , id)));
    }

    @Override
    public UserUpdateDTO updateUser(Integer id, UserUpdateDTO req) {
        User u = findById(id);
        u = UserMapper.buildUpdateUser(u,req);
        return UserMapper.toUpdateDto(userRepository.save(u));
    }

    @Override
    public Void deleteUserById(Integer id) {
        User u = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("user with id %s not found",id)));
        userRepository.delete(u);
return null;
    }


}

