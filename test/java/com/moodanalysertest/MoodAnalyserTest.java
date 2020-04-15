package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyserException;
import com.moodAnalyser.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
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
}
