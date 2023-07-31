package main;

public class Distance extends Unit{
	
	public Distance(String id) {
		
		this.setId(id);
		this.setName(decodeName(id));
		this.setBase(decodeBase(id));
	
	}
	
		private String decodeName(String id) {
			
			String name;
		
			switch(id) {
			
			case "m":
				name = "Meter";
			break;
		
			case "km":
				name = "Kilometer";
			break;
		
			case "in":
				name = "Inch";
			break;
		
			case "ft":
				name = "Foot";
			break;
		
			case "mi":
				name = "Mile";
			break;
		
			case "cm":
				name = "Centimeter";
			break;
		
			case "mm":
				name = "Milimeter";
			break;
		
			default:
				name = "Meter";
			}
			
			return name;
			
		}
	
		
		private double decodeBase(String id) {
	
			double base;

switch(id) {
			
			case "m":
				base = 1.0;
			break;
		
			case "km":
				base = 1000.0;
			break;
		
			case "in":
				base = 0.0254;
			break;
		
			case "ft":
				base = 0.3048;
			break;
		
			case "mi":
				base = 1609.0;
			break;
		
			case "cm":
				base = 0.01;
			break;
		
			case "mm":
				base = 0.001;
			break;
		
			default:
				base = 1.0;
			}
			return base;
	}

}
