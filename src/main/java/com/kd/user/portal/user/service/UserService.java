package com.kd.user.portal.user.service;

import com.kd.user.portal.user.dto.UserDTO;
import com.kd.user.portal.user.dto.UserResponse;
import com.kd.user.portal.user.exception.UserValidationException;

public interface UserService {

    UserResponse saveUser(UserDTO userDTO) throws UserValidationException;

    UserResponse getUserById(String userId) throws UserValidationException;

    UserDTO updateUser(UserDTO userDTO, String userId);

    UserResponse deleteUser(String userId);



}
