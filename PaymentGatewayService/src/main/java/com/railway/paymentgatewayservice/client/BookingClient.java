package com.railway.paymentgatewayservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TICKETBOOKINGSERVICE")
public interface BookingClient {

    @GetMapping("/ticket/amount/{pnr}")
    public double getTicketAmount(@PathVariable String pnr);
}
