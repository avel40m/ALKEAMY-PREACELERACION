package com.alkeamy.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alkeamy.auth.entity.UserEntity;
import com.alkeamy.auth.exception.UserAlreadyExistException;
import com.alkeamy.auth.repository.UserRepository;
import com.alkeamy.service.EmailService;
import com.alkeamy.auth.dto.UserDTO;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       UserEntity userEntity = userRepository.findByUsername(userName);
       if (userEntity == null) {
           throw new UsernameNotFoundException("User or password not found");
       }

       return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public boolean save(UserDTO userDTO) throws UserAlreadyExistException {
        if(checkIfUserExist(userDTO.getUsername())){
            throw new UserAlreadyExistException("User already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);

        if (userEntity != null) {
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }
}
