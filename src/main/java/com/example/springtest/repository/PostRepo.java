package com.example.springtest.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springtest.entity.PostEntity;

public interface  PostRepo extends CrudRepository<PostEntity, Long> {

}
