package com.example.pfemed.controller;

import com.example.pfemed.models.Mission;
import com.example.pfemed.models.User;
import com.example.pfemed.models.Vehicule;
import com.example.pfemed.repository.UserRepository;
import com.example.pfemed.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/User")
public class UserControlleur {

    ///injection
    private UserService userService;
    private UserRepository userRepository ;


    @PostMapping("/login")
    public ResponseEntity<?> authentification(@RequestBody User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return new ResponseEntity<>("Email ou mot de passe manquant", HttpStatus.BAD_REQUEST);
        }

        User authenticatedUser = this.userRepository.authentification(user.getUsername(), user.getPassword());

        if (authenticatedUser == null) {
            return new ResponseEntity<>("Identifiants invalides", HttpStatus.UNAUTHORIZED);
        }
        // user accepter par l admin ou non
        if (authenticatedUser.getEnable() == null || !authenticatedUser.getEnable()) {
            return new ResponseEntity<>("Utilisateur non activé", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User u )
    {
        User addedUser = userService.addUser(u);
                return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> U = userService.AllUsers();
        return ResponseEntity.ok(U);
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<User> getMissionById(@PathVariable Long id) {
        User user = userService.getUserByid(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User u) {
        return userRepository.findById(id)
            .map(existingUser -> {
                existingUser.setNom(u.getNom());
                existingUser.setPrenom(u.getPrenom());
                existingUser.setUsername(u.getUsername());

                existingUser.setGrade(u.getGrade());

                User updatedUser = userRepository.save(existingUser);
                return ResponseEntity.ok(updatedUser);
            })
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    @PutMapping("/acceptUser/{idE}")
    public ResponseEntity<User> acceptUser(@RequestBody User u, @PathVariable Long idE) {
        System.out.println("Received user: " + u);
        User addedUser = userService.EnabledTrue(u, idE);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }


}
