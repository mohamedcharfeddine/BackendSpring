package com.example.pfemed.repository;

import com.example.pfemed.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long > {
    @Query("SELECT auth FROM User auth where auth.username = ?1 and auth.password = ?2 ")
    User authentification(String username, String password);

}
