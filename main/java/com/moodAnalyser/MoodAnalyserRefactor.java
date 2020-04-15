package com.moodAnalyser;

public class MoodAnalyserRefactor {
    String message;
    public MoodAnalyserRefactor(){

    }
    public MoodAnalyserRefactor(String message){
        this.message=message;
    }
    public String analyseMood() throws MoodAnalyserException {
        try {
            if(message.length()==0)
                throw  new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"EMPTY MOOD");
            if (message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }catch(NullPointerException e){
            throw  new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"NULL MOOD");
        }
    }
    public boolean isEqualsObject(Object another){
        if (this.getClass().equals(another.getClass()))
            return true;
        return false;
    }
}
