package com.MyCricket.MyCricket.Entity;

public class Team {
    private String id;
    private String name;
    private String headCoach;
    private String battingCoach;
    private String bowlingCoach;
    private String fieldingCoach;
    private Player captain;
    private Player[] players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
    }

    public String getBattingCoach() {
        return battingCoach;
    }

    public void setBattingCoach(String battingCoach) {
        this.battingCoach = battingCoach;
    }

    public String getBowlingCoach() {
        return bowlingCoach;
    }

    public void setBowlingCoach(String bowlingCoach) {
        this.bowlingCoach = bowlingCoach;
    }

    public String getFieldingCoach() {
        return fieldingCoach;
    }

    public void setFieldingCoach(String fieldingCoach) {
        this.fieldingCoach = fieldingCoach;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
