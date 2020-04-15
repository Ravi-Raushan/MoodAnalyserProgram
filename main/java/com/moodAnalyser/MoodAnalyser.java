package com.moodAnalyser;

public class MoodAnalyser {
    String message;
    public  MoodAnalyser(){
    }
    public MoodAnalyser(String message){
        this.message=message;
    }
    public String analyseMood() {
        if (message.contains("sad"))
            return "SAD";
        return "HAPPY";
    }
}
