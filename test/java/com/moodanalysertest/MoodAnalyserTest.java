package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyserException;
import com.moodAnalyser.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    @Test
    public void SetHappyMessageWithReflectorShouldReturnHAPPY() {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getThisConstructor("com.moodAnalyser.MoodAnalyser", String.class);
            Object object = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,"I am in sad mood");
            MoodAnalyserReflector.setField(object, "message", "I m in happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(object, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
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
    }
