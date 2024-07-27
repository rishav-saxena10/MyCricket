package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.VenueEntity;
import com.MyCricket.MyCricket.Error.Error;
import com.MyCricket.MyCricket.Repository.VenueRepository;
import com.MyCricket.MyCricket.Service.VenueService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class VenueController {

    private static final Logger log = LogManager.getLogger(VenueController.class);

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private VenueService venueService;

    @GetMapping("/fetchVenue/{venueId}")
    public ResponseEntity<?> getVenue(@PathVariable String venueId){
        try {
            log.info(System.out.printf("Venue Id: %s", venueId));
            VenueEntity venueResponse = venueService.fetchVenueById(venueId);
            return ResponseEntity.status(HttpStatus.OK).body(venueResponse);
        }
        catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }

    @PostMapping("/createVenue")
    public ResponseEntity<?> createVenue(@RequestBody VenueEntity venues){
        try {
            VenueEntity venueResponse = venueService.createVenue(venues);
            log.info(System.out.printf("VenueResponse: %s", venueResponse.toString()));
            return ResponseEntity.status(HttpStatus.CREATED).body(venueResponse);
        }
        catch(BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }

    @PutMapping("/updateVenue/{venueId}")
    public ResponseEntity<?> updateVenue(@PathVariable String venueId,
                                                   @RequestBody VenueEntity venueDetails){
        try{
            VenueEntity venueResponse = venueService.updateVenue(venueId, venueDetails);
            log.info(System.out.printf("VenueResponse: %s", venueResponse.toString()));
            return ResponseEntity.status(HttpStatus.OK).body(venueResponse);
        }
        catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }

    @DeleteMapping(path = "/deleteVenue/{venueId}")
    public ResponseEntity<?> deleteVenue(@PathVariable String venueId) {
        try {
            log.info(System.out.printf("Venue Id: %s", venueId));
            venueService.deleteVenue(venueId);
            return ResponseEntity.status(HttpStatus.OK).body("Venue deleted successfully");
        }
        catch(BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }
}
