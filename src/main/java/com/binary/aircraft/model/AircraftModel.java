package com.binary.aircraft.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class AircraftModel {
    @Id
    @Column(name="aircraft_id")
    private Integer aircraftId;
    @Column(name="aircraft_type")
    private String aircraftType;
    @Column(name="aircraft_size")
    private Integer aircraftSize;
    @Column(name="aircraft_timestamp")
    private LocalDateTime aircraftTimeStamp;
}