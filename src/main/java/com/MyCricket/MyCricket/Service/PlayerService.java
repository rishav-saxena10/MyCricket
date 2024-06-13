package com.MyCricket.MyCricket.Service;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Error.Error;
import com.MyCricket.MyCricket.Factory.PlayerFactory;
import com.MyCricket.MyCricket.Model.Player;
import com.MyCricket.MyCricket.Repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerFactory playerFactory;

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerEntity createPlayer(PlayerEntity playerEntity) throws Exception {
//        Add validation here over player entity
        Error err = this.validatePlayerRequest(playerEntity);
        if(err != null)
            throw new BadRequestException(err.getErrorDescription());

//        Persist PlayerFactory model in DB
        Player playerModel = playerRepository.save(playerFactory.buildPlayer(playerEntity));
        return this.convertModelToEntity(playerModel);
    }

    public PlayerEntity fetchPlayerById(String playerId) throws Exception {
        if(playerId == null || playerId.isEmpty())
            throw new BadRequestException("Invalid Player Id");

        Optional<Player> player = playerRepository.findById(playerId);
        if(player.isEmpty())
            throw new EntityNotFoundException("Player not found");
        return this.convertModelToEntity(player.get());
    }

    public PlayerEntity updatePlayer(String playerId, PlayerEntity playerEntity) throws Exception {
       if(playerId == null || playerId.isEmpty())
           throw new BadRequestException("Invalid Player Id");

        Optional<Player> player = playerRepository.findById(playerId);
        if(player.isEmpty())
            throw new EntityNotFoundException("Player not found");

        Error err = this.validatePlayerRequest(playerEntity);
        if(err != null)
            throw new BadRequestException(err.getErrorDescription());

        Player updatedPlayer = this.updatePlayerModel(player.get(), playerEntity);
        Player playerModel = playerRepository.save(updatedPlayer);

        return this.convertModelToEntity(playerModel);
    }

    public Error validatePlayerRequest(PlayerEntity playerEntity) {
        if(playerEntity.getName() == null || playerEntity.getName().isEmpty())
            return new Error("Invalid Player Name");
        if(playerEntity.getAge() == null || playerEntity.getAge() == 0)
            return new Error("Invalid Player Age");
        if(playerEntity.getGender() == null || playerEntity.getGender().isEmpty())
            return new Error("Invalid Player Gender");
        if(playerEntity.getDob() == null)
            return new Error("Invalid Player Date of Birth");
        if(playerEntity.getBirthPlace() == null || playerEntity.getBirthPlace().isEmpty())
            return new Error("Invalid Player BirthPlace");
        if(playerEntity.getCountry() == null || playerEntity.getCountry().isEmpty())
            return new Error("Invalid Player Country");
        if(playerEntity.getRole() == null || playerEntity.getRole().isEmpty())
            return new Error("Invalid Player Role");
        if(playerEntity.getHeight() == null || playerEntity.getHeight() == 0.0)
            return new Error("Invalid Player Height");
        if(playerEntity.getWeight() == null || playerEntity.getWeight() == 0.0)
            return new Error("Invalid Player Weight");
        if(playerEntity.getBattingStyle() == null || playerEntity.getBattingStyle().isEmpty())
            return new Error("Invalid Player Batting Style");
        if(playerEntity.getBowlingStyle() == null || playerEntity.getBowlingStyle().isEmpty())
            return new Error("Invalid Player Bowling Style");

        return null;
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