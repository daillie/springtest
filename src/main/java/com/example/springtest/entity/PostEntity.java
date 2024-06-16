package com.example.springtest.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class PostEntity {
//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;	
	@ManyToOne
	@JoinColumn(name = "authorId", nullable = false)
	private UserEntity author;
	
	@Column(nullable = false)
	private String textContent;
//
	public PostEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long postId) {
		this.id = postId;
	}

	public UserEntity getAuthor() {
		return author;
	}

	public void setAuthor(UserEntity author) {
		this.author = author;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

}
