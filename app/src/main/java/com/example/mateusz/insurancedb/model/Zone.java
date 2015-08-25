package com.example.mateusz.insurancedb.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class Zone {
	private final int zoneId;
	private final UsageType zoneType;
	private final float zoneValue;
	private final String zoneLabel;

	public Zone(int zoneId, UsageType zoneType, float zoneValue, String zoneLabel) {
		this.zoneId = zoneId;
		this.zoneType = zoneType;
		this.zoneValue = zoneValue;
		this.zoneLabel = zoneLabel;
	}

	public String getZoneLabel() {
		return zoneLabel;
	}

	public int getZoneId() {
		return zoneId;
	}

	public UsageType getZoneType() {
		return zoneType;
	}

	public float getZoneValue() {
		return zoneValue;
	}
}
