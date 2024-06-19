package com.MyCricket.MyCricket.Repository;

import com.MyCricket.MyCricket.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, String> {

}