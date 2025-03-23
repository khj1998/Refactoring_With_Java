package com.java_refactoring._12_repeated_switches._02_improvment;

public class SwitchImprovements {

    public int vacationHours(String type) {
        int result;
        switch (type) {
            case "full-time" -> {
                return 120;
            }
            case "part-time" -> {
                return 80;
            }
            case "temporal" -> {
                return 32;
            }
            default -> {
                return 0;
            }
        }
    }
}
