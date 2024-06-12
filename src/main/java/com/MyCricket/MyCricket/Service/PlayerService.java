package com.MyCricket.MyCricket.Service;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player buildPlayer(PlayerEntity playerEntity) {
        return new Player(playerEntity);
    }

    public PlayerEntity createPlayer(PlayerEntity playerEntity) {
//        Add validation here over player entity

//        Persist Player model in DB
        Player playerModel = playerRepository.save(this.buildPlayer(playerEntity));
        return convertModelToEntity(playerModel);
    }

    public PlayerEntity convertModelToEntity(Player player) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(player.getId());
        playerEntity.setName(player.getName());
        playerEntity.setAge(player.getAge());
        playerEntity.setGender(player.getGender());
        playerEntity.setDob(player.getDob());
        playerEntity.setBirthPlace(player.getBirthPlace());
        playerEntity.setCountry(player.getCountry());
        playerEntity.setRole(player.getRole());
        playerEntity.setHeight(player.getHeight());
        playerEntity.setWeight(player.getWeight());
        playerEntity.setBattingStyle(player.getBattingStyle());
        playerEntity.setBowlingStyle(player.getBowlingStyle());

        return playerEntity;
    }
}