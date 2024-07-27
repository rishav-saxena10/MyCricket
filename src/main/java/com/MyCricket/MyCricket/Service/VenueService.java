package com.MyCricket.MyCricket.Service;

import com.MyCricket.MyCricket.Entity.VenueEntity;
import com.MyCricket.MyCricket.Error.Error;
import com.MyCricket.MyCricket.Factory.VenueFactory;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Model.Venue;
import com.MyCricket.MyCricket.Repository.VenueRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    VenueFactory venueFactory;

    public VenueEntity createVenue(VenueEntity venueEntity) throws BadRequestException {
        Error err = this.validateVenueRequest(venueEntity);
        if(err != null)
            throw new BadRequestException(err.getErrorDescription());

        Venue venue = venueRepository.save(venueFactory.buildVenue(venueEntity));
        return this.convertModelToEntity(venue);
    }

    public VenueEntity fetchVenueById(String venueId) throws Exception {
        if(venueId == null || venueId.isEmpty())
            throw new BadRequestException("Invalid Venue Id");
        Optional<Venue> venue = venueRepository.findById(venueId);
        if(venue.isEmpty())
            throw new EntityNotFoundException("Venue not found");
        return this.convertModelToEntity(venue.get());
    }

    public VenueEntity updateVenue(String venueId, VenueEntity venueDetails) throws Exception {
        if(venueId == null || venueId.isEmpty())
            throw new BadRequestException("Invalid Venue Id");
        Optional<Venue> venue = venueRepository.findById(venueId);
        if(venue.isEmpty())
            throw new EntityNotFoundException("Venue not found");
        Error err = this.validateVenueRequest(venueDetails);
        if(err != null)
            throw new BadRequestException(err.getErrorDescription());
        Venue updatedVenue = this.updateVenueModel(venue.get(),venueDetails);
        Venue venueModel = venueRepository.save(updatedVenue);
        return this.convertModelToEntity(venueModel);
    }

    public void deleteVenue(String venueId) throws BadRequestException {
        if(venueId == null || venueId.isEmpty())
            throw new BadRequestException("Invalid Venue Id");
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new EntityNotFoundException("Venue not found"));
        venueRepository.deleteById(venueId);
    }

//    @Transactional
//    public void softDelete(String venueId) {
//        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new EntityNotFoundException("Venue not found"));
//        venue.softDelete();
//        venueRepository.save(venue);
//    }

    private Venue updateVenueModel(Venue venueModel, VenueEntity venueDetails) {
        if(!venueDetails.getName().isEmpty())
            venueModel.setName(venueDetails.getName());
        if(!venueDetails.getCountry().isEmpty())
            venueModel.setCountry(venueDetails.getCountry());
        if(!venueDetails.getCity().isEmpty())
            venueModel.setCity(venueDetails.getCity());
        return venueModel;
    }

    private Error validateVenueRequest(VenueEntity venueEntity) {
        if(venueEntity.getCountry() == null || venueEntity.getCountry().isEmpty())
            return new Error("Invalid Country Name");
        if(venueEntity.getCity() == null || venueEntity.getCity().isEmpty())
            return new Error("Invalid City Name");
        if(venueEntity.getName() == null || venueEntity.getName().isEmpty())
            return new Error("Invalid Venue Name");
        return null;
    }

    private VenueEntity convertModelToEntity(Venue venueModel) {
        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setName(venueModel.getName());
        venueEntity.setCountry(venueModel.getCountry());
        venueEntity.setCity(venueModel.getCity());
        return venueEntity;
    }

}
