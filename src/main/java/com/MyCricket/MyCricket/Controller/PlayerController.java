package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Error.Error;
import com.MyCricket.MyCricket.Service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class PlayerController {
    private static final Logger log = LogManager.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @PostMapping(path = "/createPlayer")
    public ResponseEntity<?> createPlayer(@RequestBody PlayerEntity player) {
        try {
            PlayerEntity playerResponse = playerService.createPlayer(player);
            log.info(System.out.printf("PlayerFactory: %s", playerResponse.toString()));
            return ResponseEntity.status(HttpStatus.CREATED).body(playerResponse);
        }
        catch(BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
        }
    }

    @GetMapping(path = "/fetchPlayer/{playerId}")
    public ResponseEntity<?> fetchPlayerById(@PathVariable String playerId) {
        try {
            log.info(System.out.printf("Player Id: %s", playerId));
            PlayerEntity playerResponse = playerService.fetchPlayerById(playerId);
            return ResponseEntity.status(HttpStatus.OK).body(playerResponse);
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

    @PutMapping(path = "/updatePlayer/{playerId}")
    public ResponseEntity<?> updatePlayer(@PathVariable String playerId, @RequestBody PlayerEntity player) {
        try {
            log.info(System.out.printf("Player: %s", player.toString()));
            PlayerEntity playerResponse = playerService.updatePlayer(playerId, player);
            return ResponseEntity.status(HttpStatus.OK).body(playerResponse);
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

    @DeleteMapping(path = "/deletePlayer/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable String playerId) {
        try {
            log.info(System.out.printf("Player Id: %s", playerId));
            playerService.deletePlayer(playerId);
            return ResponseEntity.status(HttpStatus.OK).body("Player deleted successfully");
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
