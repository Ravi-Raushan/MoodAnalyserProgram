package com.moodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

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
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASS_ILLEGAL_ACCESS, "CLASS "+constructor+ " ACCESS ISSUE");
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASS_INVOCATION_ERROR, "CLASS_INVOCATION_ERROR");
        }
    }
    public static Object invokeMethod(Object objectClass, String methodName) throws MoodAnalyserException
    {
        try
        {
            return objectClass.getClass().getMethod(methodName).invoke(objectClass);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, methodName+" NO_SUCH_METHOD");
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_ILLEGAL_ACCESS,
                    "METHOD_ILLEGAL_ACCESS "+methodName);
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ERROR,
                    "METHOD_INVOCATION_ERROR "+methodName);
        }
    }
}
