package com.example.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springtest.entity.PostEntity;
import com.example.springtest.entity.UserEntity;
import com.example.springtest.repository.PostRepo;
import com.example.springtest.repository.UserRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserRepo userRepo;

	public PostEntity createPost(Long userId, PostEntity newPost) {
		UserEntity user = userRepo.findById(userId).get();
		newPost.setAuthor(user);		
		return postRepo.save(newPost);
	}
	
	public PostEntity editPost(Long postId, PostEntity newPost) {
		PostEntity oldPost = postRepo.findById(postId).get();
		oldPost.setTextContent(newPost.getTextContent());
		return postRepo.save(oldPost);
	}

}
