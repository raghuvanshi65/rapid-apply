package com.example.rapidapply.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PowerStringTokenizer {
    public static String listToString(List<String> skillSubsetList) {
        return skillSubsetList.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

    public static List<String> stringToList(String skillSubset) {
        return Arrays.asList(skillSubset.split(","));
    }
}
