package com.java_refactoring._18_middle_man._04_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * refactoring smell : 하위 클래스를 상위 클래스에서 참조하도록 수정한다. 아래와 같은 케이스에서 고려할 만한 리펙토링.
 * 다중 상속이 허용되지 않으므로, 여러 카테고리의 기능을 추가해야할 때.
 * 상위 클래스에 변경 발생시 하위 클래스에 영향이 갈 수 있으며, 구조적 단점까지 하위 클래스가 안게되는 경우.
 * 컴포지션을 사용하여 의존성을 줄이고 싶은 경우
 */
public class Booking {

    protected Show show;

    protected LocalDateTime time;

    protected PremiumDelegate premiumDelegate;

    public static Booking createBooking(Show show,LocalDateTime time) {
        return new Booking(show, time);
    }

    public static Booking createPremiumBooking(Show show, LocalDateTime time,PremiumExtra extra) {
        Booking booking = createBooking(show,time);
        booking.premiumDelegate = new PremiumDelegate(booking,extra);
        return booking;
    }

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    public boolean hasTalkback() {
        return checkHasPremiumDelegate() ? this.premiumDelegate.hasTalkback() :
        this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double basePrice = this.show.getPrice();
        if (this.isPeakDay()) basePrice += Math.round(basePrice * 0.15);

        return checkHasPremiumDelegate() ? this.premiumDelegate.extendBasePrice(basePrice) : basePrice;
    }

    public boolean hasDinner() {
        return checkHasPremiumDelegate() && this.premiumDelegate.hasDinner();
    }

    private boolean checkHasPremiumDelegate() {
        return this.premiumDelegate != null;
    }
}
