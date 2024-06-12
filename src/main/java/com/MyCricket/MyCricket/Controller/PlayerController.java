package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Service.PlayerService;
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
    public ResponseEntity<PlayerEntity> createPlayer(@RequestBody PlayerEntity player) {
        PlayerEntity playerResponse = playerService.createPlayer(player);
        log.info(System.out.printf("Player: %s", playerResponse.toString()));
        return ResponseEntity.status(HttpStatus.CREATED).body(playerResponse);
    }

    @GetMapping(path = "/fetchPlayer/{playerId}")
    public ResponseEntity<PlayerEntity> fetchPlayerById(@PathVariable String playerId) {
        log.info(System.out.printf("Player Id: %s", playerId));
        PlayerEntity playerResponse = playerService.fetchPlayerById(playerId);
        if(playerResponse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(playerResponse);
        return ResponseEntity.status(HttpStatus.OK).body(playerResponse);
    }

    @PutMapping(path = "/updatePlayer/{playerId}")
    public ResponseEntity<PlayerEntity> updatePlayer(@PathVariable String playerId, @RequestBody PlayerEntity player) {
        log.info(System.out.printf("Player: %s", player.toString()));
        PlayerEntity playerResponse = playerService.updatePlayer(playerId, player);
        if(playerResponse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(playerResponse);
        return ResponseEntity.status(HttpStatus.OK).body(playerResponse);
    }
}
