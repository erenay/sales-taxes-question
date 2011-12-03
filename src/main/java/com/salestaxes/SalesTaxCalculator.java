package com.salestaxes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SalesTaxCalculator implements TaxCalculator {
	
	private Set<Integer> exemptTypes = new HashSet<Integer>();
	

	SalesTaxCalculator(Set<Integer> exemptTypes){
		this.exemptTypes = exemptTypes;
	}
	
	SalesTaxCalculator(){

	}
	
	public Set<Item> calculateTaxes(Set<Item> items) {
		
		Set<Item> taxedItems = new HashSet<Item>();
		
		Iterator<Item> itItem = items.iterator();
		while (itItem.hasNext() ){
			Item item = itItem.next();
			if (item.isImported()) item = new ImportTaxDecorator(item);
			if (!exemptTypes.contains(item.getType())) item = new SalesTaxDecorator(item);
			taxedItems.add(item);
		}

		return taxedItems;
			
	}

	
}
