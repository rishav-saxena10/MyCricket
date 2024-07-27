package com.MyCricket.MyCricket.Entity;

import java.time.LocalDateTime;
import java.util.List;

public class TeamEntity {
    private String id;
    private String name;
    private String headCoach;
    private String battingCoach;
    private String bowlingCoach;
    private String fieldingCoach;
    private String captainId;
    private List<String> players;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

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

    public String getCaptainId() {
        return captainId;
    }

    public void setCaptain(String captain) {
        this.captainId = captain;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
