package com.dyerframeworks.geocode.service;

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.dyerframeworks.geocode.domain.Address
import com.dyerframeworks.geocode.domain.Location
import com.dyerframeworks.geocode.service.impl.GeocodeServiceImpl

/**
 * Integration testing for {@link GeocodeService}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["/spring/application-context.xml"] )
class GeocodeServiceTest {
	
	@Autowired
	GeocodeService geocodeService
	
	/**
	 * Happy path testing for {@link GeocodeService#geoCodeAddress(
	 * com.dyerframeworks.geocode.domain.Address)} with an actual {@link Address}
	 * and an expected {@link Location} object with known latitude and longitude
	 * values.
	 */
	@Test
	public void testGeoCodeAddress() {
		Address address = new Address(streetName:'301 N Tryon St', city:'Charlotte', state:'NC', zipCode:'28202')
		Location location = geocodeService.retrieveLocationForAddress(address)
		assertEquals('35.229601', location.latitude)
		assertEquals('-80.8409269', location.longitude)
	}

}
