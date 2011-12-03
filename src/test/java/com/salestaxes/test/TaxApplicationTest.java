package com.salestaxes.test;

import java.util.HashMap;
import java.util.Map;

import com.salestaxes.Item;
import com.salestaxes.Order;
import com.salestaxes.SaleManager;
import com.salestaxes.SimpleItem;

import junit.framework.TestCase;
import static com.salestaxes.SaleManager.*;

public class TaxApplicationTest extends TestCase {

	SaleManager saleManager = SaleManager.getInstance();
	
	
	public void testTotal1Correct() {
		
		double bookShelfPrice = 12.49;
		double cdShelfPrice = 14.99;
		double chocolateBarShelfPrice = 0.85;	
		double expectedTotal = 29.83;
		SimpleItem book = new SimpleItem("Book", TYPE_BOOK, bookShelfPrice);
		SimpleItem musicCD = new SimpleItem("Music CD", TYPE_OTHER, cdShelfPrice);
		SimpleItem chocolateBar = new SimpleItem("Chocolate Bar", TYPE_FOOD, chocolateBarShelfPrice);
		
		Map<Item, Integer> cashierInput = new HashMap<Item, Integer>();		
		cashierInput.put(book, 1);
		cashierInput.put(musicCD, 1);
		cashierInput.put(chocolateBar, 1);
		Order order = new Order(cashierInput);
		Order newOrder = saleManager.makeOrder(order);
		
		assertEquals(expectedTotal, newOrder.getTotal());

	}
	
	public void testTotal2Correct(){
		
		double importedBoxOfChocolatePrice = 10.00;
		double importedParfumePrice = 47.50;	
		double expectedTotal = 65.15;		
		SimpleItem importedBoxOfChocolate = new SimpleItem("Imported box of chocolates", TYPE_FOOD, importedBoxOfChocolatePrice);
		importedBoxOfChocolate.setImported(true);
		SimpleItem importedParfume = new SimpleItem("Imported bottle of parfume", TYPE_OTHER, importedParfumePrice);
		importedParfume.setImported(true);
		
		Map<Item, Integer> cashierInput = new HashMap<Item, Integer>();
		cashierInput.put(importedBoxOfChocolate, 1);
		cashierInput.put(importedParfume, 1);
		Order order = new Order(cashierInput);
		Order newOrder = saleManager.makeOrder(order);
		
		assertEquals(expectedTotal, newOrder.getTotal());
	}
	
	public void testTotal3Correct(){
		double importedParfumePrice = 27.99;	
		double parfumePrice = 18.99;
		double headAchePillsPrice = 9.75;	
		double importedBoxOfChocolatePrice = 11.25;
		double expectedTotal = 74.68;	
		
		SimpleItem importedParfume = new SimpleItem("Imported bottle of parfume", TYPE_OTHER, importedParfumePrice);
		importedParfume.setImported(true);
		SimpleItem parfume = new SimpleItem("Bottle of parfume", TYPE_OTHER, parfumePrice);
		SimpleItem headAchePills = new SimpleItem("Packet of headache pills", TYPE_MEDICAL, headAchePillsPrice);
		SimpleItem importedBoxOfChocolate = new SimpleItem("Imported box of chocolates", TYPE_FOOD, importedBoxOfChocolatePrice);
		importedBoxOfChocolate.setImported(true);
		
		Map<Item, Integer> cashierInput = new HashMap<Item, Integer>();
		cashierInput.put(importedParfume, 1);
		cashierInput.put(parfume, 1);
		cashierInput.put(headAchePills, 1);
		cashierInput.put(importedBoxOfChocolate, 1);
		Order order = new Order(cashierInput);
		Order newOrder = saleManager.makeOrder(order);
		
		assertEquals(expectedTotal, newOrder.getTotal());
	}
	
	
	public static void main(String args[]) {
	      org.junit.runner.JUnitCore.main("com.salestaxes.test.TaxApplicationTest");
	    }

	
}
