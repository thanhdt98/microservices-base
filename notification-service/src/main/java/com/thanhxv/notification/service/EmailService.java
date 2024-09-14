package com.thanhxv.notification.service;

import com.thanhxv.notification.dto.request.EmailRequest;
import com.thanhxv.notification.dto.request.SendEmailRequest;
import com.thanhxv.notification.dto.request.Sender;
import com.thanhxv.notification.dto.response.EmailResponse;
import com.thanhxv.notification.exception.AppException;
import com.thanhxv.notification.exception.ErrorCode;
import com.thanhxv.notification.httpclient.EmailClient;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    String apiKey = "your-brevo-apikey";

    public EmailResponse sendEmail(SendEmailRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("4me")
                        .email("thanhxv14.doaz@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();

        try {
            EmailResponse response = emailClient.sendEmail(apiKey, emailRequest);
            return response;
        } catch (FeignException e) {
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }

    }

}
