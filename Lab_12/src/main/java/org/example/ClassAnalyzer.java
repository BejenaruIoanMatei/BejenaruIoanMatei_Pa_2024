package org.example;

import java.lang.reflect.Method;

public class ClassAnalyzer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java org.example.ClassAnalyzer <class-name>");
            return;
        }

        String className = args[0];

        try {

            System.out.println('\n');
            //incarc clasa
            Class<?> cls = Class.forName(className);

            //partea de informatii despre metodele clasei
            System.out.println("Metodele clasei " + className + ":");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);

                //vad daca metoda e cu @test
                if (method.isAnnotationPresent(Test.class) &&
                        java.lang.reflect.Modifier.isStatic(method.getModifiers()) &&
                        method.getParameterCount() == 0) {

                    //invocarea metodei
                    System.out.println("Invocand metoda @Test: " + method.getName());
                    method.invoke(null);

                }
                System.out.println('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
