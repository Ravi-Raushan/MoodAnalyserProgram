package com.moodAnalyser;

public class MoodAnalyserException extends Exception{
    enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,INSTANT_CREATION_ERROR,CLASS_ILLEGAL_ACCESS,
        CLASS_INVOCATION_ERROR;
    }
    public ExceptionType type;
    public MoodAnalyserException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
}
