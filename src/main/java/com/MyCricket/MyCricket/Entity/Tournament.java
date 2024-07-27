package com.MyCricket.MyCricket.Entity;

import java.util.Date;

public class Tournament {
    private String id;
    private String title;
    private String format;
    private Date startDate;
    private Date finalDate;
    private String host;
    private VenueEntity[] venues;
    private Match[] matches;
    private PointsTable pointsTable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public VenueEntity[] getVenues() {
        return venues;
    }

    public void setVenues(VenueEntity[] venues) {
        this.venues = venues;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }

    public PointsTable getPointsTable() {
        return pointsTable;
    }

    public void setPointsTable(PointsTable pointsTable) {
        this.pointsTable = pointsTable;
    }
}
