package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.TeamEntity;
import com.MyCricket.MyCricket.Error.Error;
import com.MyCricket.MyCricket.Service.TeamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/")
public class TeamController {
    private static final Logger log = LogManager.getLogger(TeamController.class);

    @Autowired
    TeamService teamService;

    @PostMapping(path = "/createTeam")
    public ResponseEntity<?> createTeam(@RequestBody TeamEntity team) {
        try {
            TeamEntity teamResponse = teamService.createTeam(team);
            log.info(System.out.printf("TeamResponse: %s", teamResponse.toString()));
            return ResponseEntity.status(HttpStatus.CREATED).body(teamResponse);
        }
        catch(BadRequestException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new Error(e.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }

    @GetMapping(path = "/fetchTeam/{teamId}")
    public ResponseEntity<?> fetchTeamById(@PathVariable String teamId) {
        try {
            TeamEntity teamResponse = teamService.fetchTeamById(teamId);
            log.info(System.out.printf("TeamResponse: %s", teamResponse.toString()));
            return ResponseEntity.status(HttpStatus.OK).body(teamResponse);
        }
        catch(BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }

    @PutMapping(path = "updateTeam/{teamId}")
    public ResponseEntity<?> updateTeam(@PathVariable String teamId, @RequestBody TeamEntity team) {
        try {
            TeamEntity teamResponse = teamService.updateTeam(teamId, team);
            log.info(System.out.printf("Team: %s", team.getPlayers().getFirst()));
            return ResponseEntity.status(HttpStatus.OK).body(teamResponse);
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

    @DeleteMapping(path = "/deleteTeam/{teamId}")
    public ResponseEntity<?> deleteTeam(@PathVariable String teamId) {
        try {
            log.info(System.out.printf("Team Id: %s", teamId));
            teamService.deleteTeam(teamId);
            return ResponseEntity.status(HttpStatus.OK).body("Team deleted successfully");
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
}
