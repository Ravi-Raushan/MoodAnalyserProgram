package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyser;
import com.moodAnalyser.MoodAnalyserException;
import com.moodAnalyser.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    @Test
    public void givenMessageInConstructorShouldReturnSad() {
       try {
           MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
           String mood = moodAnalyser.analyseMood();
           Assert.assertEquals("SAD", mood);
       }catch (MoodAnalyserException e){
           e.printStackTrace();
       }
    }
    @Test
    public void givenMessageInConstructorShouldReturnHappy() {
       try {
           MoodAnalyser moodAnalyser = new MoodAnalyser("i am in happy mood");
           String mood = moodAnalyser.analyseMood();
           Assert.assertEquals("HAPPY", mood);
       }catch (MoodAnalyserException e){
           e.printStackTrace();
       }
    }
    @Test
    public void givenEmptyMoodShouldThrowMoodAnalyserException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("EMPTY MOOD", e.getMessage());
        }
    }
    @Test
    public void givenNullMoodShouldThrowMoodAnalyserException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("NULL MOOD", e.getMessage());
        }
    }
    @Test
    public void givenHappyMessageUsingReflationWhenProperShouldReturnHappyMood(){
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getThisConstructor("com.moodAnalyser.MoodAnalyser",String.class);
              Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,
                                                  "i am in happy mood");
              Object mood = MoodAnalyserReflector.invokeMethod(obj,"analyseMood");
             Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessageWhenImproperMethodShouldThrowMoodAnalyserException(){
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getThisConstructor("com.moodAnalyser.MoodAnalyser",String.class);
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,
                    "i am in happy mood");
            Object mood = MoodAnalyserReflector.invokeMethod(obj,"analysisOfMood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("analysisOfMood NO_SUCH_METHOD",e.getMessage());
        }
    }
    @Test
    public void SetHappyMessageWithReflectorShouldReturnHAPPY() {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getThisConstructor("com.moodAnalyser.MoodAnalyser", String.class);
            Object object = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,"I am in sad mood");
            MoodAnalyserReflector.setField(object, "message", "I m in sad Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(object, "analyseMood");
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void SetFieldWhenImproperShouldThrowExceptionWithNoSuchField() {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getThisConstructor("com.moodAnalyser.MoodAnalyser", String.class);
            Object object = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,"I am in sad mood");
            MoodAnalyserReflector.setField(object, "message1", "I m in happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(object, "analyseMood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("message1 NO_SUCH_FIELD", e.getMessage());
        }
    }
    @Test
    public void SettingNullMessageWithReflectorShouldThrowException() {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getThisConstructor("com.moodAnalyser.MoodAnalyser", String.class);
            Object object = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,"I am in sad mood");
            MoodAnalyserReflector.setField(object, "message", null );
            Object mood = MoodAnalyserReflector.invokeMethod(object, "analyseMood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("METHOD_INVOCATION_ERROR analyseMood", e.getMessage());
        }
    }

}
