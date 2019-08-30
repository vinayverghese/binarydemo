package com.binary.aircraft.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class EnqueueRequest {
    private String enqueueType;
    private String enqueueSize;

}