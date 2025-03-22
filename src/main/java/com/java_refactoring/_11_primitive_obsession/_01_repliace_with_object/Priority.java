package com.java_refactoring._11_primitive_obsession._01_repliace_with_object;

import java.util.List;

public class Priority {
    private String value;

    private List<String> legalValues = List.of("low","normal","high","rush");

    public Priority(String value) {
        validateValue(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

    public boolean higherThan(Priority other) {
        return this.index() > other.index();
    }

    private void validateValue(String value) {
        if (this.legalValues.contains(value)) {
            this.value = value;
        } else {
            throw new IllegalStateException("Illegal value : "+value);
        }
    }

    private int index() {
        return this.legalValues.indexOf(this.value);
    }
}
