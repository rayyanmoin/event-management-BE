package com.rayyan.eventmanagement.service;

import com.rayyan.eventmanagement.model.EventTemplate;
import com.rayyan.eventmanagement.repositories.EventTemplateRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.util.regex.Matcher;

import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EventTemplateRepository eventTemplateRepository;

    @Value("${app.mail.from}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender,EventTemplateRepository eventTemplateRepository) {
        this.mailSender = mailSender;
        this.eventTemplateRepository = eventTemplateRepository;
    }

    public void sendEventInvites(String eventTitle, String description, String location, String eventDate, String eventTime, List<String> recipientEmails) {

        EventTemplate eventTemplate = eventTemplateRepository.findByName("party_template");
        String htmlTemplate = eventTemplate.getBody();

        for (String toEmail : recipientEmails) {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                helper.setFrom(fromEmail);
                helper.setTo(toEmail);
                helper.setSubject("You're invited to: " + eventTitle);

                // Safe replacement of placeholders
                String htmlBody = htmlTemplate
                        .replaceAll("\\$\\{title}", Matcher.quoteReplacement(eventTitle))
                        .replaceAll("\\$\\{description}", Matcher.quoteReplacement(description))
                        .replaceAll("\\$\\{location}", Matcher.quoteReplacement(location))
                        .replaceAll("\\$\\{eventdate}", Matcher.quoteReplacement(eventDate))
                        .replaceAll("\\$\\{time}", Matcher.quoteReplacement(eventTime));

                helper.setText(htmlBody, true); // HTML mode

                mailSender.send(mimeMessage);

            } catch (Exception e) {
                e.printStackTrace(); // Better to log
            }
        }
    }
}

