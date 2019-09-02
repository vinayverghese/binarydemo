package com.binary.aircraft.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EnqueueRequest {
    private String enqueueType;
    private String enqueueSize;
    private Integer position;
}