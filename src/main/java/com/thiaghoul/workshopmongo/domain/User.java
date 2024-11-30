package com.thiaghoul.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //attributes
    @Id
    private String id;

    private String name;
    private String email;


     // List of posts associated with the user.
     // Annotated with @DBRef to create a reference to another collection (Post).
     // The 'lazy = true' option ensures posts are loaded only when accessed (lazy loading).
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    //constructors
    public User() {}

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.id = id;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    //hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
