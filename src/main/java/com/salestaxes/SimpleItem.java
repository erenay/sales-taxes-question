package com.salestaxes;

public class SimpleItem implements Item{

	private String name;
	private boolean isImported;
	private boolean isExempt;
	private double shelfPrice;
	private int type;
	
	public SimpleItem(String name, int type, double shelfPrice) {
		this.name = name;
		this.shelfPrice = shelfPrice;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	public boolean isExempt() {
		return isExempt;
	}

	public void setExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}

	public Item filter() {
		return this;
	}

	public void setShelfPrice(double price){
		this.shelfPrice = price;
	}
	public double getShelfPrice() {
		return this.shelfPrice;
	}

	public double getPrice() {
		return shelfPrice;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+type;
	}

	public int getType() {
		return this.type;
	}
}
