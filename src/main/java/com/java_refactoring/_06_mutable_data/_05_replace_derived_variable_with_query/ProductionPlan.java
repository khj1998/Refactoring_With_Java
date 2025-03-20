package com.java_refactoring._06_mutable_data._05_replace_derived_variable_with_query;

import java.util.ArrayList;
import java.util.List;

/**
 * refactoring smell : 다른 변수(필드)로부터 파생될 수 있응 변수(or 필드)는 제거할 수 있다.
 */
public class ProductionPlan {
    private List<Double> adjustments = new ArrayList<>();

    public void applyAdjustment(double adjustment) {
        this.adjustments.add(adjustment);
    }

    public double getProduction() {
        return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
    }
}
