package com.thiaghoul.workshopmongo.dto;

import com.thiaghoul.workshopmongo.domain.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

//DTO representing a comment in the system
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;

    //author of the comment, represented as an AuthorDTO
    private AuthorDTO author;


    //constructors
    public CommentDTO(){}

    public CommentDTO(String text, Date date, AuthorDTO author){
        this.text = text;
        this.date = date;
        this.author = author;
    }

    //getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
