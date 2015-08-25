package com.example.mateusz.insurancedb.model;

import com.example.mateusz.insurancedb.model.customer.Customer;
import com.example.mateusz.insurancedb.model.vehicle.Vehicle;

import java.util.Collection;
import java.util.Date;

public class Oc {
	public static final String NEW_OC_ID = "0";

	private final Customer customer;
	private final Vehicle vehicle;
	private final Collection<Discount> discounts;
	private final Zone zone;
	private final String placeOfIssue;
	private final Date dateOfIssue;
	private final Date dateBegin;
	private final Date dateFinish;
	private final Insurer insurer;
	private final float premium;
	private final String ocId;

	public Customer getCustomer() {
		return customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Collection<Discount> getDiscounts() {
		return discounts;
	}

	public Zone getZone() {
		return zone;
	}

	public String getPlaceOfIssue() {
		return placeOfIssue;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public Insurer getInsurer() {
		return insurer;
	}

	public float getPremium() {
		return premium;
	}

	public String getOcId() {
		return ocId;
	}

	public Oc(OcBuilder builder) {
		if (builder.customer == null) throw new NullPointerException("customer not found");
		if (builder.vehicle == null) throw new NullPointerException("vehicle not found");
		if (builder.discounts == null) throw new NullPointerException("discounts not found");
		if (builder.zone == null) throw new NullPointerException("zone not found");
		if (builder.placeOfIssue == null) throw new NullPointerException("placeOfIssue not found");
		if (builder.dateOfIssue == null) throw new NullPointerException("dateOfIssue not found");
		if (builder.dateBegin == null) throw new NullPointerException("dateBegin not found");
		if (builder.dateFinish == null) throw new NullPointerException("dateFinish not found");
		if (builder.insurer == null) throw new NullPointerException("insurer not found");

		customer = builder.customer;
		vehicle = builder.vehicle;
		discounts = builder.discounts;
		zone = builder.zone;
		placeOfIssue = builder.placeOfIssue;
		dateOfIssue = builder.dateOfIssue;
		dateBegin = builder.dateBegin;
		dateFinish = builder.dateFinish;
		insurer = builder.insurer;
		ocId = builder.ocId != null ? builder.ocId : NEW_OC_ID;
		premium = calculatePremium(vehicle.getCapacity(),zone.getZoneValue(),discounts);
	}

	private float calculatePremium(float carCapacity, float zoneValue, Collection<Discount> discounts) {
		//TODO: Premium rules
		return 0;
	}
}
