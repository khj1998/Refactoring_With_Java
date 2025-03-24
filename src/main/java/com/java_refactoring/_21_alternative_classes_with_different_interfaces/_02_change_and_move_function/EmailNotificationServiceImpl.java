package com.java_refactoring._21_alternative_classes_with_different_interfaces._02_change_and_move_function;

public class EmailNotificationServiceImpl implements NotificationService {

    private final EmailService emailService;

    public EmailNotificationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void send(Notification notification) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTitle(notification.getTitle() + " is shipped");
        emailMessage.setTo(notification.getReceiver());
        emailMessage.setFrom(notification.getSender());
        emailService.sendEmail(emailMessage);
    }
}
