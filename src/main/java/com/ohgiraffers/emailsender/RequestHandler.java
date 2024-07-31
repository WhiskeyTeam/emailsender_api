package com.ohgiraffers.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class RequestHandler {
    private final EmailService emailService;

    @Autowired
    public RequestHandler(EmailService emailService) {
        this.emailService = emailService;
    }

    // todo. change params to a json object
    @PostMapping("/send")
    public String sendEmail(@RequestBody RequestObject req) {
        emailService.sendSimpleMessage(req.getTo(), req.getSubject(), req.getText());
        return "Email sent successfully";
    }
}
