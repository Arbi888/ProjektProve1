package ProjektiProve.service.imp;

import ProjektiProve.dto.UserDTO;
import ProjektiProve.dto.UserUpdateDTO;
import ProjektiProve.exception.ResourceNotFountException;
import ProjektiProve.mapper.UserMapper;
import ProjektiProve.model.Role;
import ProjektiProve.model.User;
import ProjektiProve.repository.UserRepository;
import ProjektiProve.service.UserService;
import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class UserServiceImp implements  UserService, UserDetailsService {

     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO, String userRole) {
        User u = UserMapper.toEntity(userDTO);
        u.setUserRole(userRole != null ? Role.fromValue(userRole) : Role.CUSTOMER);
        u.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        u = userRepository.save(u);
        return UserMapper.toDTO(u);
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



        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return userRepository.findByEmail(email)
                    .orElseThrow(
                            () -> new ResourceNotFountException(
                                    String.format("User with email %s not found",email)));
        }
    }


