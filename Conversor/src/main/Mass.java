package main;

public class Mass extends Unit {
public Mass(String id) {
		
		this.setId(id);
		this.setName(decodeName(id));
		this.setBase(decodeBase(id));
	
	}
	
		private String decodeName(String id) {
			
			String name;
		
			switch(id) {
			
			case "g":
				name = "Gram";
			break;
		
			case "kg":
				name = "Kilogram";
			break;
		
			case "mg":
				name = "Miligram";
			break;
		
			case "t":
				name = "Tonne";
			break;
		
			case "lb":
				name = "Pound";
			break;
		
			case "oz":
				name = "Ounce";
			break;
		
			case "dr":
				name = "Dram";
			break;
			
			case "gr":
				name = "Grain";
			break;
		
			case "cwt":
				name = "US Hundredweight";
			break;
		
			default:
				name = "Meter";
			}
			
			return name;
			
		}
	
		
		private double decodeBase(String id) {
	
			double base;

switch(id) {
			
			case "g":
				base = 1.0;
			break;
		
			case "kg":
				base = 1000.0;
			break;
		
			case "mg":
				base = 0.001;
			break;
		
			case "t":
				base = 1000000.0;
			break;
		
			case "lb":
				base = 453.59;
			break;
		
			case "oz":
				base = 28.35;
			break;
		
			case "dr":
				base = 1.77;
			break;
			
			case "gr":
				base = 0.06;
			break;
		
			case "cwt":
				base = 453359.0;
			break;
		
			default:
				base = 1.0;
			}
			return base;
	}
}
