package com.binary.aircraft.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name="aircraft", schema="binary")
public class AircraftModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="aircraft_id")
    private Integer aircraftId;

    @Column(name="aircraft_type")
    private String aircraftType;

    @Column(name="aircraft_size")
    private String aircraftSize;

    @Column(name="aircraft_status")
    private String aircraftStatus;

    @Column(name="aircraft_position")
    private Integer aircraftPosition;

    @CreationTimestamp
    @Column(name="aircraft_creation_timestamp")
    private LocalDateTime creationTime;

    @UpdateTimestamp
    @Column(name="aircraft_update_timestamp")
    private LocalDateTime updateTime;

}