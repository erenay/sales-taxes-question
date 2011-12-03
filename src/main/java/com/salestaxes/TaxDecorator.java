package com.salestaxes;

public abstract class TaxDecorator implements Item{
	     
	protected Item item;
	
	protected double rate;
	
	abstract double getRate();
	
	public TaxDecorator(Item item){
		this.item = item;
	}
	
	public double getPrice(){
		double salesTax = Util.nearest5Percent(this.item.getShelfPrice() * this.getRate());	
		return Util.roundPrice(this.item.getPrice() + salesTax);
	}
	
}
