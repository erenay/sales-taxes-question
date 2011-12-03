package com.salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {

	static double nearest5Percent(double amount){
		
		return new BigDecimal(Math.ceil(amount * 20)/20).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
	}

	public static double roundPrice(double amount) {
		
		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
	
	}
}
