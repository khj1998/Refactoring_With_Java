package com.java_refactoring._21_alternative_classes_with_different_interfaces._02_change_and_move_function;

public class AlertNotificationServiceImpl implements NotificationService {

    private final AlertService alertService;

    public AlertNotificationServiceImpl(AlertService alertService) {
        this.alertService = alertService;
    }

    @Override
    public void send(Notification notification) {
        AlertMessage alertMessage = new AlertMessage();
        alertMessage.setMessage(notification.toString() + " is shipped");
        alertMessage.setFor(notification.getReceiver());
        alertService.add(alertMessage);
    }
}
