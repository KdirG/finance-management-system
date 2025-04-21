package com.kadir.financetracker.service;
import com.kadir.financetracker.model.User;
import com.kadir.financetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service

public class UserService{
private final UserRepository userRepository;

@Autowired
 public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

// Tüm kullanıcıları getir
public List<User> getAllUsers() {
    return userRepository.findAll();
}

// ID'ye göre kullanıcı getir
public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
}

// Yeni kullanıcı kaydet
public User saveUser(User user) {
    return userRepository.save(user);
}

// Kullanıcı sil
public void deleteUser(Long id) {
    userRepository.deleteById(id);
}

}