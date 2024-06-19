package com.MyCricket.MyCricket.Service;

import com.MyCricket.MyCricket.Entity.TeamEntity;
import com.MyCricket.MyCricket.Entity.TeamEntity;
import com.MyCricket.MyCricket.Error.Error;
import com.MyCricket.MyCricket.Factory.TeamFactory;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Model.Team;
import com.MyCricket.MyCricket.Model.Team;
import com.MyCricket.MyCricket.Repository.TeamRepository;
import com.MyCricket.MyCricket.Repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamFactory teamFactory;

    @Autowired
    TeamRepository teamRepository;

    public TeamEntity createTeam(TeamEntity teamEntity) throws Exception {
        Error err = this.validateTeamRequest(teamEntity);
        if(err != null)
            throw new BadRequestException(err.getErrorDescription());

        Team teamModel = teamRepository.save(teamFactory.buildTeam(teamEntity));
        return this.convertModelToEntity(teamModel);
    }

    public TeamEntity fetchTeamById(String teamId) throws Exception {
        if(teamId == null || teamId.isEmpty())
            throw new BadRequestException("Invalid Team Id");

        Optional<Team> teamModel = teamRepository.findActiveTeamById(teamId);
        if(teamModel.isEmpty())
            throw new EntityNotFoundException("Team not found");

        return this.convertModelToEntity(teamModel.get());
    }

    public TeamEntity updateTeam(String teamId, TeamEntity teamEntity) throws Exception {
        if(teamId == null || teamId.isEmpty())
            throw new BadRequestException("Invalid Team Id");

        Optional<Team> team = teamRepository.findActiveTeamById(teamId);
        if(team.isEmpty())
            throw new EntityNotFoundException("Team not found");

        Error err = this.validateTeamRequest(teamEntity);
        if(err != null)
            throw new BadRequestException(err.getErrorDescription());

        Team updatedTeam = this.updateTeamModel(team.get(), teamEntity);
        Team teamModel = teamRepository.save(updatedTeam);

        return this.convertModelToEntity(teamModel);
    }

    public void deleteTeam(String teamId) throws BadRequestException {
        if(teamId == null || teamId.isEmpty())
            throw new BadRequestException("Invalid Team Id");

        softDelete(teamId);
    }

    @Transactional
    public void softDelete(String teamId) {
        Team team = teamRepository.findActiveTeamById(teamId).orElseThrow(() -> new EntityNotFoundException("Team not found"));
        team.softDelete();
        teamRepository.save(team);
    }

    public Error validateTeamRequest(TeamEntity teamEntity) {
        if(teamEntity.getName() == null || teamEntity.getName().isEmpty())
            return new Error("Invalid Team Name");
        if(teamEntity.getHeadCoach() == null || teamEntity.getHeadCoach().isEmpty())
            return new Error("Invalid Team Head Coach");
        if(teamEntity.getBattingCoach() == null || teamEntity.getBattingCoach().isEmpty())
            return new Error("Invalid Batting Coach");
        if(teamEntity.getBowlingCoach() == null || teamEntity.getBowlingCoach().isEmpty())
            return new Error("Invalid Bowling Coach");
        if(teamEntity.getFieldingCoach() == null || teamEntity.getFieldingCoach().isEmpty())
            return new Error("Invalid Fielding Coach");
        if(teamEntity.getCaptainId() == null || teamEntity.getCaptainId().isEmpty())
            return new Error("Invalid Captain Id");

        return null;
    }

    public Team updateTeamModel(Team teamModel, TeamEntity teamEntity) {
        if(!teamEntity.getName().isEmpty())
            teamModel.setName(teamEntity.getName());
        if(teamEntity.getHeadCoach() != null)
            teamModel.setHeadCoach(teamEntity.getHeadCoach());
        if(!teamEntity.getBattingCoach().isEmpty())
            teamModel.setBattingCoach(teamEntity.getBattingCoach());
        if(teamEntity.getBowlingCoach() != null)
            teamModel.setBowlingCoach(teamEntity.getBowlingCoach());
        if(!teamEntity.getFieldingCoach().isEmpty())
            teamModel.setFieldingCoach(teamEntity.getFieldingCoach());
        teamModel.setUpdatedAt(LocalDateTime.now());

        return teamModel;
    }

    public TeamEntity convertModelToEntity(Team team) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(team.getId());
        teamEntity.setName(team.getName());
        teamEntity.setHeadCoach(team.getHeadCoach());
        teamEntity.setBattingCoach(team.getBattingCoach());
        teamEntity.setBowlingCoach(team.getBowlingCoach());
        teamEntity.setFieldingCoach(team.getFieldingCoach());
        teamEntity.setCaptain(team.getCaptain().getId());
        teamEntity.setActive(team.getActive());
        teamEntity.setCreatedAt(team.getCreatedAt());
        teamEntity.setUpdatedAt(team.getUpdatedAt());
        teamEntity.setDeletedAt(team.getDeletedAt());

        return teamEntity;
    }

}
