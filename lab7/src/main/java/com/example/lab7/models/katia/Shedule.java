package com.example.lab7.models.katia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
public class Shedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="route_id")
    private Integer routeId;
    private Integer bus_id;

    @Column(name = "date_")
    private String date;

    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "arrival_time")
    private String arrivalTime;


    public Shedule(Integer route_id, Integer bus_id, String date, String departureTime, String arrivalTime) {
        this.routeId = route_id;
        this.bus_id = bus_id;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
