package com.ensemble.ensemble_core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="Events")
@Table(name="Events")
@Data
public class Event {
    @SequenceGenerator(name="event_sequence",sequenceName ="event_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
    @Id
    private int eventId;
    private String eventTitle;
    private String eventDescription;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "locationId", referencedColumnName = "locationId")
    private Location venue;
    private String organizer;
    private List<String> usersAttending;
}
