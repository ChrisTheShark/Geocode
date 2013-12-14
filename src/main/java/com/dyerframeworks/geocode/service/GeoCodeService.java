package com.dyerframeworks.geocode.service;

import com.dyerframeworks.geocode.domain.Address;
import com.dyerframeworks.geocode.domain.Location;

/**
 * Interface declaring functionality required for any <code>class</code> providing
 * {@link Address} {@link Location} lookup.
 * 
 * @author Chris Dyer
 */
public interface GeoCodeService {
	
	/**
	 * Locate a {@link Location} for an {@link Address}. The resulting
	 * {@link Location} object will be populated with latitude and
	 * longitude information.
	 * 
	 * @param address the target {@link Address} object
	 * @return the created {@link Location} object
	 */
	Location retrieveLocationForAddress(Address address);

}
