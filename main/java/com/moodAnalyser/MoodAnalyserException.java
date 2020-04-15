package com.moodAnalyser;

public class MoodAnalyserException extends Exception{
    enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,INSTANT_CREATION_ERROR,CLASS_ILLEGAL_ACCESS,
        CLASS_INVOCATION_ERROR,METHOD_ILLEGAL_ACCESS,METHOD_INVOCATION_ERROR,NO_SUCH_FIELD,FIELD_ACCESSIBILITY_ERROR;
    }
    public ExceptionType type;
    public MoodAnalyserException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
    public MoodAnalyserException(ExceptionType type, String message, Throwable cause ){
        super(message);
        this.type = type;
    }
}
