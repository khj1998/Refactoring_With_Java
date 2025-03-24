package com.java_refactoring._21_alternative_classes_with_different_interfaces._02_change_and_move_function;

/**
 * refactoring smell : 비슷한 기능을 하는 서로 다른 인터페이스를 하나의 인터페이스에서 수행하도록 수정.
 * 비슷한 기능을 하지만, 서로 다른 규약의 인터페이스를 사용하고 있다면 이를 공통 언터페이스를 사용하는 방안을 고려할 만 하다.
 */
public class OrderAlerts {

    private NotificationService notificationService;

    private OrderAlerts(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    
    public void alertShipped(Order order) {
        Notification notification = Notification.newNotification(order.toString() + "is shipped");
        notificationService.send(notification);
    }
}
