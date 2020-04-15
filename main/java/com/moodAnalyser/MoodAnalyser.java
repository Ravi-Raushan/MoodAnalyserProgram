package com.moodAnalyser;

public class MoodAnalyser {
    String message;
    public  MoodAnalyser(){

    }
    public MoodAnalyser(String message){
        this.message=message;
    }
    public String analyseMood() {
        try {
            if (message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }catch (NullPointerException e){
            return "HAPPY";
        }
    }
}
