package com.example.mateusz.insurancedb.model.customer;

/**
 * Created by mateusz on 27.12.14.
 */
public class Person implements Customer {
	private final String pesel;
	private final String name;
	private final String surname;
	private final Address address;

	public Person(String pesel, String name, String surname, Address address) {
		this.pesel = pesel;
		this.name = name;
		this.surname = surname;
		this.address = address;
	}

	public String getPesel() {
		return pesel;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public String getId() {
		return pesel;
	}
}
