package com.salestaxes;

import java.util.HashSet;
import java.util.Set;

public interface TaxCalculator {

	public Set<Item> calculateTaxes(Set<Item> item);
	
}
