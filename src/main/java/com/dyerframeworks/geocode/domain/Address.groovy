package com.dyerframeworks.geocode.domain

import groovy.transform.EqualsAndHashCode

/**
 * Domain class representing an <code>Address</code>.
 * 
 * @author Chris Dyer
 */
@EqualsAndHashCode
class Address {
	String name
	String streetName
	String city
	String zipCode
	String state
	Location location
}
