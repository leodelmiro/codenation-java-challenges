package com.challenge.endpoints.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }

    public ResourceNotFoundException(Object id1, Object id2, Object id3){
        super("Resource not found. Id 1: " + id1 + " Id 2: " + id2 + " Id 3: " + id3);
    }
}