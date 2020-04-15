package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessageInConstructorShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }
    @Test
    public void givenMessageInConstructorShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in happy mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }
}
