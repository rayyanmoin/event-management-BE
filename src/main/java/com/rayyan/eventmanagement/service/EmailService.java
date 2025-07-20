package com.rayyan.eventmanagement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEventInvites(String eventTitle, String description, String location, String eventDate, String eventTime,List<String> recipientEmails) {
        for (String toEmail : recipientEmails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject("You're invited to: " + eventTitle);

            String body = String.format("Event: %s\nDescription: %s\nLocation: %s\nDate: %s\nTime: %s",
                    eventTitle, description, location, eventDate, eventTime);

            message.setText(body);

            mailSender.send(message);
        }
    }
}

