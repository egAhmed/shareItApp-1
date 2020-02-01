package com.myapp.shareit.service;


import com.myapp.shareit.domain.User;
import com.myapp.shareit.exceptions.UserNotFoundException;
import com.myapp.shareit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User findUserByEmail(String email)  {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        // encrypt password
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {

        User updatedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {

        userRepository.findById(id).ifPresent(userRepository::delete);
    }


}
