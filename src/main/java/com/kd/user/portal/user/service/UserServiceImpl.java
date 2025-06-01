package com.kd.user.portal.user.service;

import com.kd.user.portal.user.dto.UserDTO;
import com.kd.user.portal.user.dto.UserResponse;
import com.kd.user.portal.user.entity.User;
import com.kd.user.portal.user.exception.UserValidationException;
import com.kd.user.portal.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse saveUser(UserDTO userDTO) throws UserValidationException {

        if(userRepository.findByUserId(userDTO.getUserId()).isPresent()){
            throw new UserValidationException("Account creation failed", new Throwable("already same user_id is used"));
        }


        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setNickname(user.getNickname() == null ? user.getUserId() : user.getNickname());

        userRepository.save(user);

        UserDTO userRes = modelMapper.map(user, UserDTO.class);

        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("Account successfully created");
        userResponse.setUser(userRes);

        return userResponse;
    }

    @Override
    public UserResponse getUserById(String userId) throws UserValidationException {

        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isEmpty()){
            throw new UserValidationException("No User found", new Throwable(""));
        }

        UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);

        return new UserResponse("User details by user_id", userDTO);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userId) {
        return null;
    }

    @Override
    public UserResponse deleteUser(String userId) {


        System.out.println("going to delete user");
        return null;
    }
}
