package com.binary.aircraft.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ListQueueRequest {

    private String queueType;
    private String queueSize;
    private String aircraftId;
}