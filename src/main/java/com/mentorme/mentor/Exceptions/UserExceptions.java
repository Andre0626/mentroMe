package com.mentorme.mentor.Exceptions;

public class UserExceptions extends RuntimeException {

    public UserExceptions(){

    }

    public UserExceptions(String message){
        super(message);
    }
}
