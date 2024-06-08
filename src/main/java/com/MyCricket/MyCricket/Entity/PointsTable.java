package com.MyCricket.MyCricket.Entity;


import org.json.simple.JSONObject;

public class PointsTable {
    private String id;
    private JSONObject data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
