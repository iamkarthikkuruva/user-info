package com.karthik.userinfo.service;

import com.karthik.userinfo.dto.UserDTO;
import com.karthik.userinfo.entity.User;
import com.karthik.userinfo.mapper.UserMapper;
import com.karthik.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Integer userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        if(fetchedUser.isPresent()){
        return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
