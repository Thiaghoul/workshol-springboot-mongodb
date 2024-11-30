package com.thiaghoul.workshopmongo.domain;

import com.thiaghoul.workshopmongo.dto.AuthorDTO;
import com.thiaghoul.workshopmongo.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//This clas represents a Post entity in the mongodb database
//@Document annotation used to indicate it is a MongoDB document
@Document
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    //attributes
    @Id
    private String id;

    private Date date;
    private String title;
    private String body;

    //Author of the post represented as an AuthorDTO
    //This provides partial about the author (id and name) to keep the post lightweight
    private AuthorDTO author;

    //List of comments on the post, represented as CommentDTO objects.
    //each comment contains partial information, such as the text and the author of the comment
    private List<CommentDTO> comments = new ArrayList<>();

    //constructors
    public Post(){}

    public Post(String id, Date date, String title, String body, AuthorDTO author){
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    //hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(date, post.date) && Objects.equals(title, post.title) && Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, title, body);
    }
}
