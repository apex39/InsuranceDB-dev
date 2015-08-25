package com.example.mateusz.insurancedb.model;

/**
 * Created by mateusz on 30.12.14.
 */
public class Discount {
	private final String name;
	private final float value;
	private final UsageType type;

	public Discount(String name, float value, UsageType type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public float getValue() {
		return value;
	}

	public UsageType getType() {
		return type;
	}
}
