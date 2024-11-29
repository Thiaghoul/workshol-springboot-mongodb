package com.thiaghoul.workshopmongo.services;

import com.thiaghoul.workshopmongo.domain.Post;
import com.thiaghoul.workshopmongo.repositories.PostRepository;
import com.thiaghoul.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(()-> new ObjectNotFoundException("id not found!"));
    }

    public List<Post> findByTitleContaining(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
