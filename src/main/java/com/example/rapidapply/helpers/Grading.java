package com.example.rapidapply.helpers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Grading {
    CGPA , PER , GRADE;

    static Map<String , Grading> stringMap = new HashMap<>();
    static {
        for(Grading grade : Grading.values()){
            stringMap.put(grade.name().toUpperCase(Locale.ROOT), grade );
        }
    }

    public static Grading getEnum(String grading){
        return stringMap.get(grading);
    }
}
