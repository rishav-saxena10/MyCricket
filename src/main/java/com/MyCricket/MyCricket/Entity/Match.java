package com.MyCricket.MyCricket.Entity;

import java.util.Date;

public class Match {
    private String id;
    private TeamEntity teamEntity;
    private TeamEntity opponentTeamEntity;
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

    public TeamEntity getTeam() {
        return teamEntity;
    }

    public void setTeam(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

    public TeamEntity getOpponentTeam() {
        return opponentTeamEntity;
    }

    public void setOpponentTeam(TeamEntity opponentTeamEntity) {
        this.opponentTeamEntity = opponentTeamEntity;
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
