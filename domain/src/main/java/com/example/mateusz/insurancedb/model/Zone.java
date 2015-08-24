package com.example.mateusz.insurancedb.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class Zone {
    private final int zoneId;
    private final Type zoneType;
    private final float zoneValue;

    enum Type {ADD, MULTIPLY}

    public Zone(int zoneId, Type zoneType, float zoneValue) {
        this.zoneId = zoneId;
        this.zoneType = zoneType;
        this.zoneValue = zoneValue;
    }

    public int getZoneId() {
        return zoneId;
    }

    public Type getZoneType() {
        return zoneType;
    }

    public float getZoneValue() {
        return zoneValue;
    }
}
