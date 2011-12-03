package com.salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Order {

	private Set<Item> taxedItems;
	
	private Map<Item, Integer> itemQuantityMap;
	
	double taxtotal = 0;
	
	double total = 0;
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	public Order(Map<Item, Integer> itemQuantityMap) {
		this.itemQuantityMap = itemQuantityMap;
		printOrderInput(itemQuantityMap);
	}

	public Set<Item> getItems() {
		return itemQuantityMap.keySet();
	}
	
	
	public void setTaxedItems(Set<Item> taxedItems) {
		this.taxedItems = taxedItems;
	}
	
	public int getQuantity(Item item){
		return itemQuantityMap.get(item);	
	}
	
	public double getTaxtotal() {
		return taxtotal;
	}

	public double getTotal() {
		return total;
	}

	private void printOrderInput(Map<Item, Integer> map) {
		System.out.println("Order input: ");
		for ( Item item : map.keySet() ){
			System.out.println(map.get(item) + " " + item.getName() + " at " + df.format(item.getShelfPrice()));
		}	
		System.out.println();
		
	}
	
	public void printOrderResults() {	
		System.out.println("Order results: ");
		for (Item item : taxedItems){		
			double itemPrice = item.getPrice();
			taxtotal += itemPrice - item.getShelfPrice();
			double subTotal = itemPrice * getQuantity(item);
			total += subTotal;
			System.out.println(getQuantity(item) + " " + item.getName() + ": " + df.format(subTotal));
		}
		total = Util.roundPrice(total);
		taxtotal = Util.nearest5Percent(taxtotal);
		System.out.println("Sales Taxes: "+taxtotal);
		System.out.println("Total: "+total);
		System.out.println();
		
	}
	
	

}
