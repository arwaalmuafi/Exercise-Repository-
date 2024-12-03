package com.example.exerciseprepository.ApiResponse;

public class ApiException extends RuntimeException {

    public ApiException(String massage){
        super(massage);
    }
}
