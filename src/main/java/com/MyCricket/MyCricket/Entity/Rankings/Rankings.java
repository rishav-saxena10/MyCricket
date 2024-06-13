package com.MyCricket.MyCricket.Entity.Rankings;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import com.MyCricket.MyCricket.Entity.PlayerEntity;

public abstract class Rankings {
    protected String id;
    protected PlayerEntity player;
    protected Float points;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }
}
