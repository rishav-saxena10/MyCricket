package com.MyCricket.MyCricket.Factory;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerFactory {
    public Player buildPlayer(PlayerEntity playerEntity) {
        return new Player(playerEntity);
    }
}
