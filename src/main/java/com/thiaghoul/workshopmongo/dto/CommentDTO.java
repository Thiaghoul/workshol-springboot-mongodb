package com.thiaghoul.workshopmongo.dto;

import com.thiaghoul.workshopmongo.domain.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;

    private AuthorDTO author;

    public CommentDTO(){}

    public CommentDTO(String text, Date date, AuthorDTO author){
        this.text = text;
        this.date = date;
        this.author = author;
    }

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

    public AuthorDTO getAuthorDTO() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
