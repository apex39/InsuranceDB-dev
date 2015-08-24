package com.example.mateusz.insurancedb.model;

import com.example.mateusz.insurancedb.model.customer.Customer;
import com.example.mateusz.insurancedb.model.vehicle.Vehicle;

import java.util.Collection;
import java.util.Date;

/**
 * Created by mateusz.bak@mobica.com on 2015-08-21.
 */
public class OcBuilder {
	 Customer customer;
	 Vehicle vehicle;
	 Collection<Discount> discounts;
	 Zone zone;
	 String placeOfIssue;
	 Date dateOfIssue;
	 Date dateBegin;
	 Date dateFinish;
	 Insurer insurer;
	 String ocId;

	public static OcBuilder oc(){
		return new OcBuilder();
	}

	public OcBuilder withCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public OcBuilder withVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}

	public OcBuilder withDiscounts(Collection<Discount> discounts) {
		this.discounts = discounts;
		return this;
	}

	public OcBuilder withZone(Zone zone) {
		this.zone = zone;
		return this;
	}

	public OcBuilder withPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
		return this;
	}

	public OcBuilder withDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
		return this;
	}

	public OcBuilder withDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
		return this;
	}

	public OcBuilder withDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
		return this;
	}

	public OcBuilder withInsurer(Insurer insurer) {
		this.insurer = insurer;
		return this;
	}

	public OcBuilder withOcId(String ocId) {
		this.ocId = ocId;
		return this;
	}

	public Oc build(){
		return new Oc(this);
	}
}
