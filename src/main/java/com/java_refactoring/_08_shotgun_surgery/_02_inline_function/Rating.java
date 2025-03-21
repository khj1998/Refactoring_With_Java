package com.java_refactoring._08_shotgun_surgery._02_inline_function;

/**
 * refactoring smell : 함수 추출하기와 반대되는 인라인 방식 리펙토링 적용.
 * 간혹 하나의 함수에서 문단 별로 나누는 것이 의도를 더 잘 드러내는 경우가 있을 수 있다.
 * 하나의 긴 함수에서 함수 추출 리펙토링 진행 중 이전 긴 함수로 돌아가고 싶은 경우 인라인 방식이 사용되기도 한다.
 */
public class Rating {

    public int rating(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5 ? 2 : 1;
    }
}
