package com.MyCricket.MyCricket.Factory;

import com.MyCricket.MyCricket.Entity.TeamEntity;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Model.Team;
import com.MyCricket.MyCricket.Repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeamFactory {
    @Autowired
    PlayerRepository playerRepository;

    public Team buildTeam(TeamEntity teamEntity) {
        Optional<Player> captain = playerRepository.findActivePlayerById(teamEntity.getCaptainId());
        if(captain.isEmpty())
            throw new EntityNotFoundException("Captain not found");

        Team team = new Team(teamEntity);
        team.setCaptain(captain.get());

        return team;
    }
}
