package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyser;
import com.moodAnalyser.MoodAnalyserException;
import com.moodAnalyser.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyserClassNameShouldReturnMoodAnalyserObject(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            MoodAnalyser anotherMoodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObjectWithParametrizeConstructor(
                                                  "com.moodAnalyser.MoodAnalyser",String.class);
            Assert.assertEquals(true,  moodAnalyser.isEqualsObject(anotherMoodAnalyserObject));
        } catch (MoodAnalyserException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassNameImproperShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyserFactory.createMoodAnalyserObjectWithParametrizeConstructor("com.moodAnalyser.MindAnalyser",String.class);
        } catch (MoodAnalyserException | IllegalAccessException | InstantiationException e) {
            Assert.assertEquals("NO_SUCH_CLASS_ERROR", e.getMessage());
        }
    }
    @Test
    public void givenImproperConstructorParameterShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObjectWithParametrizeConstructor(
                                              "com.moodAnalyser.MoodAnalyser",Integer.class);
        } catch (MoodAnalyserException | IllegalAccessException | InstantiationException e) {
            Assert.assertEquals("NO_SUCH_METHOD_ERROR", e.getMessage());
        }
    }
}
