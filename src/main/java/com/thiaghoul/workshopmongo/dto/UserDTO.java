package com.thiaghoul.workshopmongo.dto;

import com.thiaghoul.workshopmongo.domain.User;

import java.io.Serializable;

//A user data transfer object
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //attributes
    private String id;
    private String name;
    private String email;

    //constructors
    public UserDTO(){}

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

    //getter and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
