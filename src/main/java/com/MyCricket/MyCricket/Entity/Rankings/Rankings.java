package com.MyCricket.MyCricket.Entity.Rankings;

import com.MyCricket.MyCricket.Entity.Player;

public abstract class Rankings {
    protected String id;
    protected Player player;
    protected Float points;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }
}
