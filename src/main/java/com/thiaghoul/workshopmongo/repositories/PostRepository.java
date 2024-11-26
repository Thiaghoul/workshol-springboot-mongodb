package com.thiaghoul.workshopmongo.repositories;

import com.thiaghoul.workshopmongo.domain.Post;
import com.thiaghoul.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
