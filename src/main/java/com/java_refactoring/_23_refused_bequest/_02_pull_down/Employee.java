package com.java_refactoring._23_refused_bequest._02_pull_down;


/**
 * refactoring smell :
 * 상위 클래스의 필드, 메서드의 다수가 하위 클래스에서 사용하고 있지 않다면, pull-down 방식을 고려해 보아야 한다.
 * 만약 하위 클래스에서 상위 클래스의 규약과 다른 기능을 다수 사용한다면, 컴포지션을 활용해 다른 클래스를 참조할 수 있다.
 */
public class Employee {
}
