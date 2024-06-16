package com.example.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.service.PostService;
import com.example.springtest.entity.PostEntity;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping
	public ResponseEntity<Object> createPost(@RequestBody PostEntity post, @RequestParam Long userId) {
		try {
			return ResponseEntity.ok(postService.createPost(userId,post));
		} catch (Exception e) {			
			return ResponseEntity.badRequest().body("err");
		}

	}

	@PutMapping
	public ResponseEntity<Object> editPost(@RequestBody PostEntity newPostInfo, @RequestParam Long userId) {
		try {
			return ResponseEntity.ok(postService.editPost(userId, newPostInfo));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}

	}

}
