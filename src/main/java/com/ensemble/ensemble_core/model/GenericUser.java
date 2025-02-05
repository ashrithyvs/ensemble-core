package com.ensemble.ensemble_core.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("GENERIC_USER")
public class GenericUser extends User{
    @ManyToMany(mappedBy = "attendees")
    private List<Event> eventsAttending;
}
