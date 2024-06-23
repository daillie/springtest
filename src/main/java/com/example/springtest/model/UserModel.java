package com.example.springtest.model;

import com.example.springtest.entity.UserEntity;

public class UserModel {

    private Long id;

    private String email;
    private String userName;
    private String firstName;
    private String secondName;
    private int age;


    public static UserModel toModel(UserEntity userEntity) {
        UserModel model = new UserModel();
        model.setAge(userEntity.getAge());
        model.setEmail(userEntity.getEmail());
        model.setId(userEntity.getId());
        model.setFirstName(userEntity.getFirstName());
        model.setSecondName(userEntity.getSecondName());
        return model;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
