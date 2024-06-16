package com.example.springtest.service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.exceptions.DuplicateUserNameException;
import com.example.springtest.exceptions.UserNotFoundException;
import com.example.springtest.model.UserModel;
import com.example.springtest.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public UserEntity registration(UserEntity user) throws DuplicateUserNameException {	
		if (userRepo.existsByLogin(user.getUserName())) {
			System.out.println("user with username: '" + user.getUserName() + "' already exists");
			throw new DuplicateUserNameException("user with username: '" + user.getUserName() + "' is already exist.");
		}
		System.out.println("new user!");
		return userRepo.save(user);
	}

	public UserModel findById(Long id) throws UserNotFoundException {		
		Optional<UserEntity> user = userRepo.findById(id);
		if (user.isEmpty())		
			throw new UserNotFoundException("user with id: '" + id + "' not found");		
			
		return UserModel.toModel(user.get());
	}
	
	public Long deleteById(Long id) throws UserNotFoundException {		
		if(!userRepo.existsById(id)) 
			throw new UserNotFoundException("user with id: '" + id + "' not found");
		userRepo.deleteById(id);
		return id;
		
	}
	
	public UserEntity updateUser(Long id, UserEntity newUserInfo) {
		UserEntity oldUserInfo =  userRepo.findById(id).orElseThrow(() ->
		new UserNotFoundException("user with id: '" + id + "' not found"));
		
		newUserInfo.setId(id);
		userRepo.save(newUserInfo);
		return newUserInfo; 
	}
		
		
	public Collection<UserEntity> findAll(){
		
		return (Collection<UserEntity>) userRepo.findAll();
	}
	
}
