package com.ensemble.ensemble_core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Locations")
@Table(name="Locations")
@Data
public class Location {

    @SequenceGenerator(name="location_sequence",sequenceName ="location_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    @Id
    private int locationId;
    private String locationName;
    private String address;
//    private List<Event> events;
}
