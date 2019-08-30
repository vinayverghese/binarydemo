package com.binary.aircraft.service;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.request.EnqueueRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class AircraftService {


    public ResponseEntity<String> enqueueAircraft(List<EnqueueRequest> enqueueRequestList)
    {

        if(enqueueRequestList!=null && !enqueueRequestList.isEmpty())
        {

            Queue<AircraftModel> q = new LinkedList<>();

            // Adds elements {0, 1, 2, 3, 4} to queue
            for (int i=0; i<5; i++)
                q.add(i);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }



    }
}

