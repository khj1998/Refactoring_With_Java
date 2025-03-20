package com.java_refactoring._06_mutable_data._06_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

public record Reading(String customer, double quantity, Month month, Year year) {
}
