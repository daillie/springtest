package com.example.springtest.service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.springtest.exceptions.DuplicateUserEmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.exceptions.UserNotFoundException;
import com.example.springtest.entity.model.UserModel;
import com.example.springtest.repository.UserRepo;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserEntity registerByRequired(String email, String password) {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(password);
        return userRepo.save(user);
    }

    public UserEntity registration(UserEntity user) throws DuplicateUserEmailException {
        if (userRepo.existsByEmail(user.getEmail()))
            throw new DuplicateUserEmailException("user with email: '" + user.getEmail() + "' is already exist.");

        log.info("new user!");
        return userRepo.save(user);
    }

    public UserModel findById(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("user with id: '" + id + "' not found");

        return UserModel.toModel(user.get());
    }

    public boolean existsByEmail(String email) {
        log.info("checking for existing email: " + email);
        return userRepo.existsByEmail(email);
    }

    public UserEntity getByEmail(String email) throws UserNotFoundException {
        log.info("getByEmail");
        Optional<UserEntity> user = userRepo.findByEmail(email);
        return user.orElseThrow(() ->
                new UserNotFoundException("User with this email is not present"));
    }

    public Long deleteById(Long id) throws UserNotFoundException {
        if (!userRepo.existsById(id))
            throw new UserNotFoundException("user with id: '" + id + "' not found");
        userRepo.deleteById(id);
        return id;

    }

    public UserEntity updateUser(Long id, UserEntity newUserInfo) {
        UserEntity oldUserInfo = userRepo.findById(id).orElseThrow(() ->
                new UserNotFoundException("user with id: '" + id + "' not found"));

        newUserInfo.setId(id);
        userRepo.save(newUserInfo);
        return newUserInfo;
    }


    public Collection<UserEntity> findAll() {
        return (Collection<UserEntity>) userRepo.findAll();
    }

}
