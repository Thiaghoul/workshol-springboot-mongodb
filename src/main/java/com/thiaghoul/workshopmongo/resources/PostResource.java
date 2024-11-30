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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Marks this class as a REST controller, enabling it to handle HTTP requests
@RequestMapping(value = "/posts") // Specifies the base URI path for all methods in this controller
public class PostResource {

    @Autowired
    private PostService service;

    // This method handles the GET request to fetch a post by its ID
    @GetMapping(value = "/{id}")  // Maps HTTP GET requests with {id} as a path variable
    public ResponseEntity<Post> findById(@PathVariable String id) {
        // Finds a post by ID using the service method
        Post post = service.findById(id);
        // Returns a ResponseEntity containing the post object and an HTTP status of 200 OK
        return ResponseEntity.ok().body(post);
    }

    // This method handles the GET request to search posts by title
    @GetMapping(value = "/titlesearch")  // Maps HTTP GET requests for the /titlesearch endpoint
    public ResponseEntity<List<Post>> findByTitleContaining(@RequestParam(value = "text", defaultValue = "") String title) {
        // Decodes the title parameter to handle special characters in the search term
        title = URL.decodeParam(title);
        // Retrieves posts matching the title search using the service method
        List<Post> posts = service.findByTitleContaining(title);
        // Returns a ResponseEntity containing the list of matching posts
        return ResponseEntity.ok().body(posts);
    }

    // This method handles the GET request for performing a full-text search with optional date filters
    @GetMapping(value = "/fullsearch")  // Maps HTTP GET requests for the /fullsearch endpoint
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,  // Optional search term
            @RequestParam(value = "minDate", defaultValue = "") String minDate,  // Optional minimum date
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate  // Optional maximum date
    ) {
        // Decodes the search text to handle any URL-encoded characters
        text = URL.decodeParam(text);
        // Converts the minDate and maxDate parameters to Date objects, with defaults if not provided
        Date min = URL.convertDate(minDate, new Date(0L));  // Default minDate as epoch
        Date max = URL.convertDate(maxDate, new Date());  // Default maxDate as the current date
        // Retrieves posts matching the full search criteria from the service method
        List<Post> posts = service.fullSearch(text, min, max);
        // Returns a ResponseEntity containing the list of matching posts
        return ResponseEntity.ok().body(posts);
    }





}
