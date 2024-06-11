package com.MyCricket.MyCricket.Controller;

import com.MyCricket.MyCricket.Entity.Player;
import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class PlayerController {
    private static final Logger log = LogManager.getLogger(PlayerController.class);

    @PostMapping(path = "/createPlayer")
    public ResponseEntity<String> createPlayer(@RequestBody Player player) {
        log.info(System.out.printf("Player: %s", player.toString()));
        return ResponseEntity.status(HttpStatus.CREATED).body("Player created successfully");
    }

    @GetMapping(path = "/fetchPlayer/{playerId}")
    public ResponseEntity<String> fetchPlayerById(@PathVariable(value = "playerId") String playerId) {
        log.info(System.out.printf("Player Id: %s", playerId));
        return ResponseEntity.status(HttpStatus.OK).body("Player fetched successfully");
    }

    @PutMapping(path = "/updatePlayer/{playerId}")
    public ResponseEntity<String> updatePlayer(@RequestBody Player player) {
        log.info(System.out.printf("Player: %s", player.toString()));
        return ResponseEntity.status(HttpStatus.OK).body("Player updated successfully");
    }
}
