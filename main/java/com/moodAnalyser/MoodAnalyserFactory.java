package com.moodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor<?> getThisConstructor(String className,Class...param) throws MoodAnalyserException {
        try
        {
            Class getClass = Class.forName(className);
            return getClass.getConstructor(param);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "NO_SUCH_METHOD_ERROR");
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "NO_SUCH_CLASS_ERROR");
        }
    }

    public static Object createMoodAnalyserObject(Constructor constructor, Object...message) throws MoodAnalyserException {
        try
        {
            return constructor.newInstance(message);
        }
        catch (InstantiationException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.INSTANT_CREATION_ERROR, "INSTANT_CREATION_ERROR");
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASS_ILLEGAL_ACCESS, "CLASS_ILLEGAL_ACCESS");
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASS_INVOCATION_ERROR, "CLASS_INVOCATION_ERROR");
        }
    }
}
