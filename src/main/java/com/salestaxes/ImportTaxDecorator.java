package com.salestaxes;

public class ImportTaxDecorator extends TaxDecorator {
	
	Item itemtoDecorate;
	
	final double rate = 0.05;
	
	public ImportTaxDecorator(Item itemtoDecorate){
		super(itemtoDecorate);
		this.itemtoDecorate = itemtoDecorate;
	}
	
	@Override
	double getRate() {
		return this.rate;
	}

	public boolean isImported() {
		return itemtoDecorate.isImported();
	}

	public String getName() {
		return itemtoDecorate.getName();
	}

	public double getShelfPrice() {
		return itemtoDecorate.getShelfPrice();
	}

	public int getType() {
		return itemtoDecorate.getType();
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getType();
	}

	@Override
	public boolean equals(Object obj) {
	
		if (obj == null){
			return false;
		}
		else if (obj instanceof Item){
			return (((Item)obj).hashCode() == this.hashCode());

		}
		else return false;
	}
}