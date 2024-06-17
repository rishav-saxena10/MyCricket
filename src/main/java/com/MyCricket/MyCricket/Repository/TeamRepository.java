package com.MyCricket.MyCricket.Repository;

import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
    @Query("SELECT t FROM Team t WHERE t.id = :id AND t.isActive = true")
    Optional<Team> findActiveTeamById(@Param("id") String id);
}
