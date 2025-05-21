package com.railway.ticketbookingservice.client;

import com.railway.notificationservice.model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATIONSERVICE")
public interface NotificationClient {

    @PostMapping("/notifications/send-booking-confirmation")
    void sendBookingConfirmation(@RequestBody NotificationRequest request);

    @PostMapping("/notifications/send-cancellation-confirmation")
    void sendCancellationConfirmation(@RequestBody NotificationRequest request);
}
