package com.dyerframeworks.geocode.service

import com.dyerframeworks.geocode.domain.Address
import com.dyerframeworks.geocode.domain.Location
import com.dyerframeworks.geocode.service.impl.GeocodeServiceImpl
import spock.lang.Specification

/**
 * Spock testing for {@link GeocodeService}.
 */
class GeocodeServiceSpec extends Specification {
	
	GeocodeServiceImpl service;
	
	def setup() {
		service = new GeocodeServiceImpl()
		service.geocodeAPIUrl = 'http://maps.googleapis.com/maps/api/geocode/'
	}
	
	def "given an address, expect a location"() {
		given:
			Address address = new Address(streetName:'301 N Tryon St', 
				city:'Charlotte', state:'NC', zipCode:'28202')
		when:
			Location location = service.retrieveLocationForAddress(address)
		then:
			location == new Location(latitude:'35.229601', 
				longitude:'-80.8409269')
	}
	
}