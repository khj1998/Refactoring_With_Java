package com.java_refactoring._21_alternative_classes_with_different_interfaces._02_change_and_move_function;

public class OrderProcessor {

    private final NotificationService notificationService;

    public OrderProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyShipping(Shipping shipping) {
        Notification notification = Notification.newNotification(shipping.getOrder() + " is shipped");
        notificationService.send(notification);
    }

}
