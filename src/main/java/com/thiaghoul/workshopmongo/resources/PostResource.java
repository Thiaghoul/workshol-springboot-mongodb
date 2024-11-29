package com.thiaghoul.workshopmongo.resources;

import com.thiaghoul.workshopmongo.domain.Post;
import com.thiaghoul.workshopmongo.domain.User;
import com.thiaghoul.workshopmongo.dto.UserDTO;
import com.thiaghoul.workshopmongo.resources.util.URL;
import com.thiaghoul.workshopmongo.services.PostService;
import com.thiaghoul.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitleContaining(@RequestParam(value = "text", defaultValue = "") String title){
        title = URL.decodeParam(title);
        List<Post> posts = service.findByTitleContaining(title);
        return ResponseEntity.ok().body(posts);
    }





}
