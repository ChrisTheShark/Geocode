package com.dyerframeworks.geocode.service;

import static org.junit.Assert.*;

import org.junit.Test;

import spock.lang.Specification;

class CollectionsSpec extends Specification {

	def "create a list, add a value and check the size"() {
		given: "create the list with sample names"
			def names = ['john', 'tommy', 'janice']
		when: "add a new name"
			names << 'scott'
		then: "check count equals old count plus one"
			names.size == old(names.size) + 1
	}
	
	def "create a list, mutate the values and make some assertions"() {
		given: "create the list with sample names"
			def names = ['john', 'tommy', 'janice']
		when: "make all the names uppercase"
			def upperCaseNames = names.collect { name -> name.toUpperCase() }
		then: "verify all names are upper case"
			upperCaseNames[0] == 'JOHN'
			upperCaseNames[1] == 'TOMMY'
			upperCaseNames[2] == 'JANICE'
	}

}
