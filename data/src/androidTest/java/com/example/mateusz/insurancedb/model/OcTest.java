package com.example.mateusz.insurancedb.model;

import com.example.mateusz.insurancedb.model.customer.Address;
import com.example.mateusz.insurancedb.model.customer.Customer;
import com.example.mateusz.insurancedb.model.customer.Person;
import com.example.mateusz.insurancedb.model.vehicle.Car;
import com.example.mateusz.insurancedb.model.vehicle.Vehicle;

import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mateusz.bak@mobica.com on 2015-08-21.
 */
public class OcTest {

	private static final float CAPACITY = 1.3f;
	private static final String PESEL = "36521452369";

	@Test
	public void testOcBuilder() {
		Address customerAddress = new Address("51", "Bermondsey", "London");
		Customer customer = new Person(PESEL, "Mateusz", "Bąk", customerAddress);
		Vehicle car = new Car("CMG 321", "Punto", "Fiat", CAPACITY, "1FMNU40F51EB43581");
		Insurer insurer = new Insurer("John", "Smith", "jhsm");
		OcBuilder ocBuilder = new OcBuilder();

		ocBuilder.withCustomer(customer)
				.withDateBegin(new Date(2013, 12, 13))
				.withDateFinish(new Date(2015, 13, 13))
				.withDateOfIssue(new Date())
				.withInsurer(insurer)
				.withVehicle(car);

		Oc oc = ocBuilder.build();
		assertEquals(oc.getCustomer(), customer);
		assertEquals(oc.getCustomer().getAddress(), customerAddress);
		assertEquals(oc.getCustomer().getId(), PESEL);
		assertEquals(oc.getVehicle(), car);
		assertEquals(oc.getInsurer(), insurer);

	}
}