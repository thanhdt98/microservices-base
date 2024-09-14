package com.thanhxv.notification.controller;

import com.thanhxv.notification.dto.request.SendEmailRequest;
import com.thanhxv.notification.dto.response.ApiResponse;
import com.thanhxv.notification.dto.response.EmailResponse;
import com.thanhxv.notification.service.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailController {
    EmailService emailService;

    @PostMapping("/email/send")
    public ApiResponse<EmailResponse> sendEmail(@RequestBody SendEmailRequest request) {
        return ApiResponse.<EmailResponse>builder()
                .result(emailService.sendEmail(request))
                .build();
    }

    /**
     * explain
     * group la de khi service chay trong kubernetes cluster co the co nhieu instances
     * thi luc do no se dieu phoi gui message cho tung instance
     * chu neu chay nhieu instance ma khong co group thi message do se duoc gui den tat ca cac instance dan den duplicate
     */
    @KafkaListener(topics = "onboard-successful")
    public void listen(String message) {
        log.info("Message received: {}", message);
    }

}
