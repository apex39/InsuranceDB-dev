package com.example.mateusz.insurancedb.model.vehicle;

/**
 * Created by mateusz on 27.12.14.
 */
public abstract class Vehicle {
	protected static final int VIN_LENGTH = 17;
	protected String registrationNumber;
	protected String model;
	protected String brand;
	protected float capacity;
	protected String vin;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public float getCapacity() {
		return capacity;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		if (vin.length() == VIN_LENGTH) {
			this.vin = vin;
		} else {
			throw new IllegalArgumentException("VIN length doesn't equal 17");
		}
	}
}
