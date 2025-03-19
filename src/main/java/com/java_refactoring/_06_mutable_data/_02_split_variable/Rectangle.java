package com.java_refactoring._06_mutable_data._02_split_variable;

/**
 * refactoring smell : 의도를 알기 어려운 지역변수명 수정, 지역변수 수정 부분 변경 함수로 추출
 */
public class Rectangle {

    private double perimeter;
    private double area;

    public void updateGeometry(double height, double width) {
        double perimeter = updatePerimeter(height,width);
        System.out.println("Perimeter: " + perimeter);

        area = updateArea(height,width);
        System.out.println("Area: " + area);
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    private double updatePerimeter(double height,double width) {
        this.perimeter = 2 * (height + width);
        return this.perimeter;
    }

    private double updateArea(double height,double width) {
        this.area = height * width;
        return this.area;
    }
}
