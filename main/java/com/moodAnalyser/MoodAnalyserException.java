package com.moodAnalyser;

public class MoodAnalyserException extends Exception{
    enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY
    }
    public ExceptionType type;
    public MoodAnalyserException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
}
