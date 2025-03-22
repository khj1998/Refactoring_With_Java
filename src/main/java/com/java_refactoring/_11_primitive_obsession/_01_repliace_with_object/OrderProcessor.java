package com.java_refactoring._11_primitive_obsession._01_repliace_with_object;

import java.util.List;

public class OrderProcessor {

    public long numberOfHighPriorityOrders(List<Order> orders) {
        Priority normalPriority = new Priority("normal");

        return orders.stream()
                .filter(o -> o.getPriority().higherThan(normalPriority))
                .count();
    }
}
