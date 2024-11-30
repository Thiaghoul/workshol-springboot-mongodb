package com.thiaghoul.workshopmongo.resources.exception;

import com.thiaghoul.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


//Centralized exception handler for the application.
//Annotated with @ControllerAdvice to allow global exception handling across all controllers.
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Handles exceptions of type ObjectNotFoundException and returns a structured response.
     *
     * @param e       The exception object containing the error details.
     * @param request The HttpServletRequest object to extract details about the request (e.g., URI).
     * @return A ResponseEntity containing a StandardError object with error details and an HTTP status code.
     */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        // Defines the HTTP status to be returned in the response.
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Creates a StandardError object with detailed information about the error.
        StandardError err = new StandardError(System.currentTimeMillis(), //Current timestamp
                status.value(),                                           //HTTP status code(404)
                "Not found",                                              //Short description of the error
                e.getMessage(),                                           //Detailed error message from the exception
                request.getRequestURI());                                 //The URI of the request tha caused the error

        // Returns a ResponseEntity with the error details and the HTTP status code.
        return ResponseEntity.status(status).body(err);
    }
}
