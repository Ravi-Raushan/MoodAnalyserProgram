package com.moodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyserObject(String className,Class parameterClass) throws MoodAnalyserException, IllegalAccessException, InstantiationException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            return (MoodAnalyser) moodConstructor.newInstance();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "NO_SUCH_CLASS_ERROR");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "NO_SUCH_METHOD_ERROR");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser createMoodAnalyserObjectWithParametrizeConstructor(String className,Class parameterClass) throws MoodAnalyserException, IllegalAccessException, InstantiationException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(parameterClass);
            return (MoodAnalyser) moodConstructor.newInstance("i am in happy mood");
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "NO_SUCH_CLASS_ERROR");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "NO_SUCH_METHOD_ERROR");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
