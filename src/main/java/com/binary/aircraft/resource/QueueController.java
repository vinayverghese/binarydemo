package com.binary.aircraft.resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.service.AircraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RestController
@Path("/aircraft")
public class QueueController {

    @Autowired private AircraftService aircraftService;
    //@Autowired private PersonRepository personRepository;

    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity<String> enqueueAircraft(@RequestBody List<EnqueueRequest> enqueueRequest) {

        aircraftService.enqueueAircraft(enqueueRequest);
            //personRepository.persist(person);
            //return ResponseEntity.status(HttpStatus.CREATED).build()
        //return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}