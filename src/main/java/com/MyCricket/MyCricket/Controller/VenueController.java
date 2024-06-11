package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.Venue;
import com.MyCricket.MyCricket.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @PostMapping("/venues")
    public Venue createUser(@RequestBody Venue venues) {
        return venueRepository.save(venues);
    }
}
