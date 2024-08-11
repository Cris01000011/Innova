package com.example.demo.manage;

import com.example.demo.User;
import com.example.demo.dto.user;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserManage implements UserInterfaz {
    @Autowired
    private final UserData userData;

    public UserManage(UserData userData) {
        this.userData = userData;
    }

    @Override
    public List<user> getAllElements() {
        List<User> Users = userData.findAll();
        return Users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public user getById(String id) {
        User user = userData.findById(id).orElse(null);
        return convertToDto(user);
    }

    public user getByEmail(String email) {
        Optional<User> user = userData.findByEmail(email);
        return user.map(this::convertToDto).orElse(null);
    }

    @Override
    public user insert(user userDto) {
        validateUser(userDto);
        User user = convert(userDto);
        user = userData.save(user);
        return convertToDto(user);
    }

    @Override
    public user update(user user, String id) {
        validateUser(user);
        Optional<User> existingUserOptional = userData.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            updateUser(existingUser, user);
            User updatedUser = userData.save(existingUser);
            return convertToDto(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        userData.deleteById(id);
    }

    private void validateUser(user user) {
        if (user == null || user.getUser() == null) {
            throw new IllegalArgumentException("Error");
        }
    }

    private void updateUser(User existingUser, user user) {
        existingUser.setName(user.getUser());
        existingUser.setPassword(user.getPass());
        existingUser.setRole(user.getRoll());
    }

    private User convert(user user) {
        return new User(
                user.getId(),
                user.getUser(),
                user.getPass(),
                user.getRoll()
        );
    }

    private user convertToDto(User user) {
        if (user == null) return null;
        return new user(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getRole()
        );
    }
}

