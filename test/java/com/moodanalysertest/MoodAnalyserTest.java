package com.moodanalysertest;

import com.moodAnalyser.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser = new MoodAnalyser();
    @Test
    public void givenMessageShouldReturnSad() {
        String mood = moodAnalyser.analyseMood("i am in sad mood");
        Assert.assertEquals("SAD",mood);
    }
    @Test
    public void givenMessageShouldReturnHappy() {
        String mood = moodAnalyser.analyseMood("i am in any mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
