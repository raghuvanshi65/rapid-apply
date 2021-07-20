package com.example.rapidapply.helpers;

import java.util.HashMap;
import java.util.Map;

public enum Grading {
    CGPA , PER , GRADE;

    Map<Grading , String> stringMap = new HashMap<>();

    public String getStringify(Grading grading){
        return stringMap.get(grading);
    }
}
