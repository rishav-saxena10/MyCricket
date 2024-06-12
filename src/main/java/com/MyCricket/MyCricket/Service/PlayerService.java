package com.MyCricket.MyCricket.Service;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return this.convertModelToEntity(playerModel);
    }

    public PlayerEntity fetchPlayerById(String playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        return player.map(this::convertModelToEntity).orElse(null);
    }

    public PlayerEntity updatePlayer(String playerId, PlayerEntity playerEntity) {
        Optional<Player> player = playerRepository.findById(playerId);
        if(player.isEmpty())
            return null;

        Player updatedPlayer = this.updatePlayerModel(player.get(), playerEntity);
        Player playerModel = playerRepository.save(updatedPlayer);

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

    public Player updatePlayerModel(Player playerModel, PlayerEntity playerEntity) {
        if(!playerEntity.getName().isEmpty())
            playerModel.setName(playerEntity.getName());
        if(playerEntity.getAge() != null)
            playerModel.setAge(playerEntity.getAge());
        if(!playerEntity.getGender().isEmpty())
            playerModel.setGender(playerEntity.getGender());
        if(playerEntity.getDob() != null)
            playerModel.setDob(playerEntity.getDob());
        if(!playerEntity.getBirthPlace().isEmpty())
            playerModel.setBirthPlace(playerEntity.getBirthPlace());
        if(!playerEntity.getCountry().isEmpty())
            playerModel.setCountry(playerEntity.getCountry());
        if(!playerEntity.getRole().isEmpty())
            playerModel.setRole(playerEntity.getRole());
        if(playerEntity.getHeight() != null)
            playerModel.setHeight(playerEntity.getHeight());
        if(playerEntity.getWeight() != null)
            playerModel.setWeight(playerEntity.getWeight());
        if(playerEntity.getBattingStyle() != null)
            playerModel.setBattingStyle(playerEntity.getBattingStyle());
        if(playerEntity.getBowlingStyle() != null)
            playerModel.setBowlingStyle(playerEntity.getBowlingStyle());

        return playerModel;
    }
}