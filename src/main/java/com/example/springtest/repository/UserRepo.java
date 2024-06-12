package com.example.springtest.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springtest.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

}
