package com.binary.aircraft.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

@Getter
@Setter
@EqualsAndHashCode
public class QueueRequest {

    @JsonIgnore
    private String queueType;

    @JsonIgnore
    private String queueSize;

    @JsonIgnore
    private Integer aircraftId;
}