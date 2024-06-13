package com.MyCricket.MyCricket.Entity.Statistics;

import com.MyCricket.MyCricket.Entity.PlayerEntity;
import org.json.simple.JSONObject;

public abstract class Statistics {
    protected String id;
    protected PlayerEntity player;
    protected String type;
    protected JSONObject stats;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONObject getStats() {
        return stats;
    }

    public void setStats(JSONObject stats) {
        this.stats = stats;
    }
}
