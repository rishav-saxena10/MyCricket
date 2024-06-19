package com.MyCricket.MyCricket.Repository;

import com.MyCricket.MyCricket.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    @Query("SELECT p FROM Player p WHERE p.id = :id AND p.isActive = true")
    Optional<Player> findActivePlayerById(@Param("id") String id);
}
