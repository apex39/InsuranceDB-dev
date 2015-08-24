package com.example.mateusz.insurancedb.model;

/**
 * Created by mateusz on 30.12.14.
 */
public class Discount {
	private final String name;
	private final float value;
	private final Type type;

	enum Type {ADD, MULTIPLY}

	public Discount(String name, float value, Type type) {
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

	public Type getType() {
		return type;
	}
}
