package com.hr_user.hr_user.services;

import com.hr_user.hr_user.entity.User;
import com.hr_user.hr_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
    }
}
