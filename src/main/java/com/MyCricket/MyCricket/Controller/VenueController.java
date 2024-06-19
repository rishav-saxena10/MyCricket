package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.Venue;
import com.MyCricket.MyCricket.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venue/{id}")
    public ResponseEntity<Optional<Venue>> getVenue(@PathVariable(value = "id") String venueId){
        Optional<Venue> venues = venueRepository.findById(venueId);
        return ResponseEntity.ok().body(venues);
    }

    @PostMapping("/venues")
    public Venue createVenue(@RequestBody Venue venues) {
        return venueRepository.save(venues);
    }

    @PutMapping("/venues/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable(value = "id") String venueId,
                                                       @RequestBody Venue venueDetails){
        Optional<Venue> venues = venueRepository.findById(venueId);

        venues.get().setName(venueDetails.getName());
        venues.get().setCity(venueDetails.getCity());
        venues.get().setCountry(venueDetails.getCountry());

        final Venue updatedVenue = venueRepository.save(venues.get());
        return ResponseEntity.ok(updatedVenue);
    }


}
