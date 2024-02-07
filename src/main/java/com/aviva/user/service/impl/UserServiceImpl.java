package com.aviva.user.service.impl;

import com.aviva.user.UserRepository;
import com.aviva.user.model.UserModel;
import com.aviva.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserModel createUser(UserModel userModel){

        return userRepository.save(userModel);
    }
}
