package com.example.pfemed.service;

import com.example.pfemed.models.Mission;
import com.example.pfemed.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> AllUsers();

    User updateUser(User u);

    User getUserByid(Long idU);

    User addUser(User u);

    void removeUser(Long idU);
    User EnabledTrue(User u , Long idE);



}
