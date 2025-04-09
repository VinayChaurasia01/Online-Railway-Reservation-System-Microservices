package com.railway.ticketbookingservice.client;

import com.railway.traininformationservice.model.Train;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TRAININFORMATIONSERVICE")
public interface TrainInformationClient {

    @GetMapping("/trains/search/{pnr}")
    Train getTrainByPnr(@PathVariable String pnr);
}
