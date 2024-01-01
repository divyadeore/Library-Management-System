package com.library.library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.Entity.user;
import com.library.library.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<user> findAll() {
        return userRepository.findAll();
    }

    public user save(user user) {
        return userRepository.save(user);
    }
}

