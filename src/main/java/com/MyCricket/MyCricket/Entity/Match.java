package com.MyCricket.MyCricket.Entity;

import java.util.Date;

public class Match {
    private String id;
    private Team team;
    private Team opponentTeam;
    private Venue venue;
    private Date startsAt;
    private String[] umpires;
    private String tvUmpire;
    private String referee;
    private String matchPlayer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(Team opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public String[] getUmpires() {
        return umpires;
    }

    public void setUmpires(String[] umpires) {
        this.umpires = umpires;
    }

    public String getTvUmpire() {
        return tvUmpire;
    }

    public void setTvUmpire(String tvUmpire) {
        this.tvUmpire = tvUmpire;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getMatchPlayer() {
        return matchPlayer;
    }

    public void setMatchPlayer(String matchPlayer) {
        this.matchPlayer = matchPlayer;
    }
}
