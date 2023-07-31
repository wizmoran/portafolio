package main;

public class Conversor {
	
	public double convert(Unit unitSource, Unit unitTarget, double quantity) {
		
		double conversion = 0;
		
		
		if(unitSource.getClass() == Temperature.class) {
/**
 * In case of converting temperatures, the program calculates the conversion through the form:
 * 
 * 					Tt = [Ts + a] * b + c
 * 
 * 					where Tt: temperature target
 * 						  Ts: temperature source
 * 						  a, b, c: coefficients of transformation
 */
			Double a = 0.0;
			Double b = 0.0;
			Double c = 0.0;
			
			String option = new String(unitSource.getId() + "->" + unitTarget.getId());
			
			
			switch(option) {
			case "K->K":
				a = 0.0;
				b = 1.0;
				c = 0.0;	
				break;
			case "K->°C":
				a = -273.15;
				b = 1.0;
				c = 0.0;
				break;
			case "K->R":
				a = 0.0;
				b = 9.0/5.0;
				c = 0.0;
				break;
			case "K->°F":
				a = 0.0;
				b = 9.0/5.0;
				c = -459.67;
				break;
			case "°C->K":
				a = 273.15;
				b = 1.0;
				c = 0.0;
				break;
			case "°C->°C":
				a = 0.0;
				b = 1.0;
				c = 0.0;
				break;
			case "°C->R":
				a = 273.15;
				b = 9.0/5.0;
				c = 0.0;
				break;
			case "°C->°F":
				a = 0.0;
				b = 9.0/5.0;
				c = 32.0;
				break;
			case "R->K":
				a = 0.0;
				b = 5.0/9.0;
				c = 0.0;
				break;
			case "R->°C":
				a = -491.67;
				b = 5.0/9.0;
				c = 0.0;
				break;
			case "R->R":
				a = 0.0;
				b = 1.0;
				c = 0.0;
				break;
			case "R->°F":
				a = -491.67;
				b = 1.0;
				c = 32.0;
				break;
			case "°F->K":
				a = -32.0;
				b = 5.0/9.0;
				c = 273.15;
				break;
			case "°F->°C":
				a = -32.0;
				b = 5.0/9.0;
				c = 0.0;
				break;
			case "°F->R":
				a = 0.0;
				b = 1.0;
				c = 459.67;
				break;
			case "°F->°F":
				a = 0.0;
				b = 1.0;
				c = 0.0;
				break;
			
			}
			
			conversion = ((quantity + a ) * b + c);
		}else{
/*
 * Non-temperature transformation type			
 */
			conversion = quantity * (unitSource.getBase())/(unitTarget.getBase());
			}
		return conversion;
	}
}
