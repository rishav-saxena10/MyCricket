package com.MyCricket.MyCricket.Factory;

import com.MyCricket.MyCricket.Entity.VenueEntity;
import com.MyCricket.MyCricket.Model.Venue;
import org.springframework.stereotype.Component;

@Component
public class VenueFactory {
    public Venue buildVenue(VenueEntity venueEntity) {
        return new Venue(venueEntity);
    }
}
