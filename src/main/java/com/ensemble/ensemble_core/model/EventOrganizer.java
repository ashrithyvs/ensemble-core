package com.ensemble.ensemble_core.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("EVENT_ORGANIZER")
public class EventOrganizer extends User{
}
