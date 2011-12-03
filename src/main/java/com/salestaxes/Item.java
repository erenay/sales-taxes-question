package com.salestaxes;

public interface Item {

	String getName();
	
	double getPrice();
	
	double getShelfPrice();
	
	boolean isImported();

	int getType();
	
}
