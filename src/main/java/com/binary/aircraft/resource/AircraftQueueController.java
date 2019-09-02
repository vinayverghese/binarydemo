package com.binary.aircraft.resource;
import java.util.List;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.request.QueueRequest;
import org.springframework.web.bind.annotation.*;


import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class AircraftQueueController {

    @Autowired
    private AircraftService aircraftService;

    @RequestMapping(value = "/enqueue", method = RequestMethod.POST)
    public ResponseEntity<String> enqueueAircraft(@RequestBody List<EnqueueRequest> enqueueRequest) {
      return  aircraftService.enqueueAircraft(enqueueRequest);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<AircraftModel>> listAircraftQueue(QueueRequest queueRequestList) {
        return  aircraftService.listAircraftQueue(queueRequestList);
    }
}