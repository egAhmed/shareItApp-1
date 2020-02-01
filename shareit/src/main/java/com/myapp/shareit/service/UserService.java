package com.myapp.shareit.service;


import com.myapp.shareit.domain.User;
import com.myapp.shareit.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    //private RoleRepository roleRepository;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.roleRepository = roleRepository;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email)  {
        return userRepository.findByEmail(email);
    }

/*    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }*/

}
