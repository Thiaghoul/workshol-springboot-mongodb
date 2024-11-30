package com.thiaghoul.workshopmongo.repositories;

import com.thiaghoul.workshopmongo.domain.Post;
import com.thiaghoul.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    /**
     * Finds posts where the title contains the specified string, ignoring case.
     *
     * @param title The text to search for in the title.
     * @return A list of posts with titles containing the specified string, case-insensitively.
     */
    List<Post> findByTitleContainingIgnoreCase(String title);

    /**
     * Custom query to find posts where the title matches a specified regex, case-insensitively.
     *
     * @param text The text to search for in the title using a regex.
     * @return A list of posts matching the regex in their title.
     */
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    /**
     * Performs a full search across multiple fields (`title`, `body`, `comments.text`)
     * and filters by date range.
     *
     * @param text     The text to search for in the fields (`title`, `body`, or `comments.text`) using a regex.
     * @param minDate  The minimum date for filtering posts.
     * @param maxDate  The maximum date for filtering posts.
     * @return A list of posts matching the search criteria within the specified date range.
     */
    @Query("{ $and: [ { date: {$gte:  ?1} }, { date: {$lte:  ?2} } ," +
            "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'body': { $regex: ?0, $options: 'i' } }, " +
            "{ 'comments.text': { $regex: ?0, $options: 'i' } } ]  } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
