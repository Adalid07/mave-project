package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Customer;
import com.rev.cat.catservice.domain.Quotation;
import com.rev.cat.catservice.service.mail.MailService;
import com.rev.cat.catservice.service.mail.model.Email;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Arrays;

/**
 * @author rveizaga
 */

@Service
public class SenderEmailService {

    private MailService emailService;


    public SenderEmailService(MailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(Quotation customer) {
        Email email = composeEmail(customer);
        try {
            emailService.send(email);
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
        }
    }

    private Email composeEmail(Quotation customer) {
        Email email = new Email();
        email.setFrom(customer.getEmail());
        email.setTo(Arrays.asList("diplomadodhv2@gmail.com"));
        email.setSubject("Message of Customer: " + customer.getName() + "by" + customer.getProductName());
        email.setBody(customer.getMessage());
        return email;
    }
}
