package com.dyerframeworks.geocode.service.impl

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Value

import org.springframework.stereotype.Component
import com.dyerframeworks.geocode.domain.Address
import com.dyerframeworks.geocode.domain.Location
import com.dyerframeworks.geocode.service.GeoCodeService

/**
 * Service implementation for {@link GeoCodeService} utilizing the Google
 * GeoCode API.
 * 
 * @author Chris Dyer
 */
@Component
class GeoCodeServiceImpl implements GeoCodeService {

	@Value('${google.geocode.url}')
	private String geocodeAPIUrl;

	@Override
	Location retrieveLocationForAddress(Address address) {
		RESTClient restClient = new RESTClient(geocodeAPIUrl)
		def addressParam = "$address.streetName, $address.city, $address.zipCode $address.state"
		Location location = null;
		/*
		 * Make webservice call and map new <code>Location</code> object.
		 */
		restClient.get(path:'json', query: [address:"$addressParam", sensor:false] ) { resp, json ->
			location = new Location(latitude:json.results.geometry.location.lat[0], 
				longitude:json.results.geometry.location.lng[0])
		}
		return location;
	}

}