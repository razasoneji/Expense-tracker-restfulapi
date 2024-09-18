package org.example.expensetracker.Controllers;

import org.example.expensetracker.Entities.User;
import org.example.expensetracker.Services.UserService;
import org.example.expensetracker.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //  C
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    //  R
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    //                  locho
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userService.findByIdUser(userId);
    }



    //   U
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {

        return userService.updateById(updatedUser,userId);


//        User existingUser = userService.findByIdUser(userId).orElse(new User());
////        updatedUser.setId(userId); // Ensure the ID is set to the correct value
//        return userService.saveUser(updatedUser);
    }

    //  D
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {

        userService.deleteByIdUser(userId);

    }

}
