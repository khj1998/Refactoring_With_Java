package com.java_refactoring._04_long_parameter_list._03_remove_flag_argument;

import java.time.LocalDate;

/**
 * refactoring smell : 기존 boolean 값을 가지는 파라미터를 제거.
 * flag 매개변수는 함수의 의도를 파악하기 어렵게 한다.
 * 여려 flag가 쓰이는 경우 단일 함수에서 너무 많은 일을 하는 것은 아닌지 점검이 필요.
 */
public class Shipment {
    public LocalDate regularDeliveryDate(Order order) {
        int deliveryTime = switch (order.getDeliveryState()) {
            case "WA", "CA" -> 2;
            case "OR", "TX", "NY" -> 3;
            default -> 4;
        };
        return order.getPlacedOn().plusDays(deliveryTime);
    }

    public LocalDate rushDeliveryDate(Order order) {
        int deliveryTime = switch (order.getDeliveryState()) {
            case "WA", "CA", "OR" -> 1;
            case "TX", "NY", "FL" -> 2;
            default -> 3;
        };
        return order.getPlacedOn().plusDays(deliveryTime);
    }
}
