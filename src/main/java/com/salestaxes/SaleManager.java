package com.salestaxes;

import java.util.HashSet;
import java.util.Set;

public class SaleManager {
	
	static final public int TYPE_BOOK = 1;
	static final public int TYPE_FOOD = 2;
	static final public int TYPE_MEDICAL = 3;
	static final public int TYPE_OTHER = 4;
	
	TaxCalculator taxCalculator;
	
	private static SaleManager instance = null;
	   
	protected SaleManager() {
	      
	}
	
	public static SaleManager getInstance() {
	    if(instance == null) {
	        instance = new SaleManager();
	        instance.taxCalculator = TaxCalculatorFactory.getInstance();
	    }
	    return instance;
	}

    public Order makeOrder (Order order) {
    	order = updateOrderWithTaxes(order);
    	order.printOrderResults();
    	return order;
    }

	private Order updateOrderWithTaxes(Order order) {

		Set<Item> taxedItems = taxCalculator.calculateTaxes(order.getItems());
    	order.setTaxedItems(taxedItems);
    	return order;
	}
    
}





