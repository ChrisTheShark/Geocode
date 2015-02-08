package com.dyerframeworks.geocode.domain

import groovy.transform.EqualsAndHashCode

/**
 * Domain class representing a <code>Location</code>, consisting of 
 * latitude and longitude coordinates.
 */
@EqualsAndHashCode
class Location {
	String latitude
	String longitude
}
