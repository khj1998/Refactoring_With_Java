package com.java_refactoring._14_lazy_element._02_collapse_hierachy;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private List<String> members;

    private String owner;

    private boolean paid;

    private String courtNumber;
}
