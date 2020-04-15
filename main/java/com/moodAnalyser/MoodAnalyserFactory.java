package com.moodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyserObject(String className,Class parameterClass) throws MoodAnalyserException, IllegalAccessException, InstantiationException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(parameterClass);
            return (MoodAnalyser) moodAnalyserClass.newInstance();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "NO_SUCH_CLASS_ERROR");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "NO_SUCH_METHOD_ERROR");
        }
    }
}
