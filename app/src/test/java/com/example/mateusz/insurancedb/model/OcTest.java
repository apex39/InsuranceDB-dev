package com.example.mateusz.insurancedb.model;

import com.example.mateusz.insurancedb.model.customer.Address;
import com.example.mateusz.insurancedb.model.customer.Customer;
import com.example.mateusz.insurancedb.model.customer.Person;
import com.example.mateusz.insurancedb.model.vehicle.Car;
import com.example.mateusz.insurancedb.model.vehicle.Vehicle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by mateusz.bak@mobica.com on 2015-08-21.
 */
public class OcTest {

	private static final float CAPACITY = 1.3f;
	private static final float PREMIUM_BASE = 100;
	private static final String PLACE_OF_ISSUE = "London";
	private static final String PESEL = "36521452369";
	Address customerAddress;
	Customer customer;
	Vehicle car;
	Insurer insurer;
	ArrayList<Discount> discounts;
	Zone zone;
	OcBuilder ocBuilder;

	@Before
	public void setup() {
		customerAddress = new Address("51", "Bermondsey", "London");
		customer = new Person(PESEL, "Mateusz", "Bąk", customerAddress);
		car = new Car("CMG 321", "Punto", "Fiat", CAPACITY, "1FMNU40F51EB43581");
		insurer = new Insurer("John", "Smith", "jhsm");

		discounts = new ArrayList<>();
		discounts.add(new Discount("Sample discount", 1.3f, UsageType.MULTIPLY));
		discounts.add(new Discount("Sample discount", 1.3f, UsageType.ADD));

		zone = new Zone(1, UsageType.ADD, 1.3f, "Sample Label");
		ocBuilder = new OcBuilder();
	}

	@Test
	public void testOcBuilder() {
		ocBuilder.withCustomer(customer)
				.withDateBegin(new Date(2013, 12, 13))
				.withDateFinish(new Date(2015, 13, 13))
				.withDateOfIssue(new Date(2013, 12, 13))
				.withInsurer(insurer)
				.withVehicle(car)
				.withDiscounts(discounts)
				.withZone(zone)
				.withPlaceOfIssue(PLACE_OF_ISSUE)
				.withPremiumBase(PREMIUM_BASE);

		Oc oc = ocBuilder.build();
		assertEquals(customer, oc.getCustomer());
		assertEquals(customerAddress, oc.getCustomer().getAddress());
		assertEquals(PESEL, oc.getCustomer().getId());
		assertEquals(car, oc.getVehicle());
		assertEquals(new Date(2013, 12, 13), oc.getDateBegin());
		assertEquals(new Date(2015, 13, 13), oc.getDateFinish());
		assertEquals(new Date(2013, 12, 13), oc.getDateOfIssue());
		assertEquals(zone, oc.getZone());
		assertEquals(insurer, oc.getInsurer());
		assertEquals(discounts, oc.getDiscounts());
		assertEquals(PLACE_OF_ISSUE, oc.getPlaceOfIssue());
		assertNotNull(oc.getPremium());
		assertEquals(Oc.NEW_OC_ID, oc.getOcId());
	}

	@Test
	public void testOcOcId() {
		String sampleId = "Sample Id";

		ocBuilder.withCustomer(customer)
				.withDateBegin(new Date(2013, 12, 13))
				.withDateFinish(new Date(2015, 13, 13))
				.withDateOfIssue(new Date(2013, 12, 13))
				.withInsurer(insurer)
				.withVehicle(car)
				.withDiscounts(discounts)
				.withZone(zone)
				.withPlaceOfIssue("Place")
				.withOcId(sampleId)
				.withPremiumBase(PREMIUM_BASE);

		Oc oc = ocBuilder.build();
		assertEquals(sampleId, oc.getOcId());
	}

	@Test(expected = NullPointerException.class)
	public void testCreatingEmptyOcThrowsNullPointerException(){
		Oc oc = ocBuilder.build();
	}
}