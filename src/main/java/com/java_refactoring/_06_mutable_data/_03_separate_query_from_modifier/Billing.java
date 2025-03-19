package com.java_refactoring._06_mutable_data._03_separate_query_from_modifier;

/**
 * refactoring smell : 하나의 함수에서 조회와 변경을 함께하는 부분을 두 함수로 나눈다. (명령형, 쿼리형 함수)
 * 변경과 조회가 하나의 함수에 있다면 하나의 기능만을 테스트하고자 할 때 어려움을 겪는다.
 */
public class Billing {

    private Customer customer;

    private EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    public double totalOutstanding() {
        return customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
    }

    public void sendBill() {
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
