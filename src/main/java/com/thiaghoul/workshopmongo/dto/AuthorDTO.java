package com.thiaghoul.workshopmongo.dto;

import com.thiaghoul.workshopmongo.domain.User;

import java.io.Serializable;

//Data Transfer Object for representing the author of a post or a comment
//Used to transfer limited user information, such as id and name, without exposing the entire User
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //attributes
    private String id;
    private String name;

    //constructors
    public AuthorDTO(){};

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }

    //getters and setters
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
}
