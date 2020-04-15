package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyser;
import com.moodAnalyser.MoodAnalyserException;
import com.moodAnalyser.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyserClassNameShouldReturnMoodAnalyserObject(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserFactory.getThisConstructor("com.moodAnalyser.MoodAnalyser",String.class);
             MoodAnalyser moodAnalyser1 = (MoodAnalyser)MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,
                                                  "i am in happy mood");
             boolean result = moodAnalyser.isEqualsObject(moodAnalyser1);
             Assert.assertTrue(result);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassNameImproperShouldThrowMoodAnalyserException() {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserFactory.getThisConstructor("com.moodAnalyser.MindAnalyser",String.class);
            MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"i am in happy mood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("NO_SUCH_CLASS_ERROR", e.getMessage());
        }
    }
    @Test
    public void givenImproperConstructorParameterShouldThrowMoodAnalyserException() {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserFactory.getThisConstructor("com.moodAnalyser.MoodAnalyser",Integer.class);
            MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"i am in happy mood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("NO_SUCH_METHOD_ERROR", e.getMessage());
        }
    }
}
