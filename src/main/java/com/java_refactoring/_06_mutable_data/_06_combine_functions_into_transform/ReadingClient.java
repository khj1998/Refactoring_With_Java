package com.java_refactoring._06_mutable_data._06_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

/**
 * refactoring smell : 반복적으로 사용하는 파생 변수 생성 함수를 하나의 변환 함수를 통해 사용하도록 한다.
 * 여러 함수를 클래스로 묶는 방법을 사용하였다.
 * 변환 함수를 통해 새로운 데이터를 생성한다.
 */
public class ReadingClient {
    protected double taxThreshold(Year year) {
        return 5;
    }

    protected double baseRate(Month month, Year year) {
        return 10;
    }

    protected EnrichReading enrichReading(Reading reading) {
        return new EnrichReading(reading,calculateBaseCharge(reading),taxableCharge(reading));
    }

    private double calculateBaseCharge(Reading reading) {
        return baseRate(reading.month(), reading.year()) * reading.quantity();
    }

    private double taxableCharge(Reading reading) {
        return Math.max(0,calculateBaseCharge(reading) - taxThreshold(reading.year()));
    }
}
