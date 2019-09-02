package com.binary.aircraft.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

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