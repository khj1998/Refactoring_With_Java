package com.java_refactoring._05_global_data._02_encapsulate_variable;

public class Thermostats {

    private static Integer targetTemperature = 70;

    private static Boolean heating = true;

    private static Boolean cooling = false;

    private static Boolean fahrenheit = true;

    public static Integer getTargetTemperature() {
        return targetTemperature;
    }

    public static Boolean getHeating() {
        return heating;
    }

    public static Boolean getCooling() {
        return cooling;
    }

    public static Boolean getFahrenheit() {
        return fahrenheit;
    }

    public static void setTargetTemperature(Integer targetTemperature) {
        Thermostats.targetTemperature = targetTemperature;
    }

    public static void setHeating(Boolean heating) {
        Thermostats.heating = heating;
    }

    public static void setCooling(Boolean cooling) {
        Thermostats.cooling = cooling;
    }

    public static void setFahrenheit(Boolean fahrenheit) {
        Thermostats.fahrenheit = fahrenheit;
    }
}
