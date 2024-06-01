package com.example.pfemed.service;

import com.example.pfemed.models.User;
import com.example.pfemed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    //injection
    @Autowired
    private UserRepository userRepository ;
    @Override
    public List<User> AllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User getUserByid(Long idU) {
        return userRepository.findById(idU).orElse(null);
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public void removeUser(Long idU) {
        userRepository.deleteById(idU);
    }

    @Override
    public User EnabledTrue(User u , Long idE) {
        User employer = userRepository.findById(idE).orElse(null);
        employer.setEnable(Boolean.TRUE);
        return userRepository.save(employer);
    }


}
