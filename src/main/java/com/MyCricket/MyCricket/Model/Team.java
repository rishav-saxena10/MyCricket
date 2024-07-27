package com.MyCricket.MyCricket.Model;

import com.MyCricket.MyCricket.Entity.TeamEntity;
import com.MyCricket.MyCricket.Utils.StringListConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(generator = "custom-generator")
    @GenericGenerator(name = "custom-generator", strategy = "com.MyCricket.MyCricket.Utils.IDGenerator")
    private String Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "head_coach", nullable = false)
    private String headCoach;

    @Column(name = "batting_coach", nullable = false)
    private String battingCoach;

    @Column(name = "bowling_coach", nullable = false)
    private String bowlingCoach;

    @Column(name = "fielding_coach", nullable = false)
    private String fieldingCoach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain_id", referencedColumnName = "id")
    private Player captain;

    @Column(name = "players", columnDefinition = "json")
    private String players;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public Team() {}

    public Team(TeamEntity teamEntity) {
        this.name = teamEntity.getName();
        this.headCoach = teamEntity.getHeadCoach();
        this.battingCoach = teamEntity.getBattingCoach();
        this.bowlingCoach = teamEntity.getBowlingCoach();
        this.fieldingCoach = teamEntity.getFieldingCoach();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
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

    @PrePersist
    protected void onCreate() {
        isActive = true;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public void softDelete() {
        this.isActive = false;
        this.deletedAt = LocalDateTime.now();
    }

}
