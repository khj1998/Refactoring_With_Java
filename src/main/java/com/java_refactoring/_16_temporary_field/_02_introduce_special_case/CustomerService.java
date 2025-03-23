package com.java_refactoring._16_temporary_field._02_introduce_special_case;

/**
 * refactoring smell : 특이 케이스를 다른 클래스로 추출한다. UnknownCustomer의 경우.
 * 특정 조건에 따라 반복 동작하는 코드는 특별한 케이스로 추출하여 구분할 수 있다.
 * 이러한 케이스의 대표적인 사례는 Null Object 패턴.
 */
public class CustomerService {

    public String customerName(Site site) {
        return site.getCustomer().getName();
    }

    public BillingPlan billingPlan(Site site) {
        return site.getCustomer().getBillingPlan();
    }

    public int weeksDelinquent(Site site) {
        return site.getCustomer().getPaymentHistory().getWeeksDelinquentInLastYear();
    }
}
