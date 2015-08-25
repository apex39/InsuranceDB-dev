package com.example.mateusz.insurancedb.model.customer;

/**
 * Created by mateusz.bak@mobica.com on 2015-08-21.
 */
public class Address {
	private final String houseNumber;
	private final String street;
	private final String city;

	public Address(String houseNumber, String street, String city) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}
}
