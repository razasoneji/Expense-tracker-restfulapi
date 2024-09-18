package org.example.expensetracker.Services;

import org.example.expensetracker.Entities.User;
import org.example.expensetracker.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByIdUser(int userId) {
        return userRepository.findById(userId);
    }


    public void deleteByIdUser(int userId) {
        userRepository.deleteById(userId);
    }

    public User updateById(User updatedUser, int userId) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }


}
