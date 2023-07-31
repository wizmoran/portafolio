package main;

public class Temperature extends Unit {
public Temperature(String id) {
		
		this.setId(id);
		this.setName(decodeName(id));
		this.setBase(1.0);
		
	
	}
	
		private String decodeName(String id) {
			
			String name;
		
			switch(id) {
			
			case "K":
				name = "Kelvin";
			break;
		
			case "R":
				name = "Rankine";
			break;
		
			case "°C":
				name = "Celsius";
			break;
		
			case "°F":
				name = "Fahrenheit";
			break;
		
			
			default:
				name = "Kelvin";
			}
			
			return name;
			
		}
	
		
		
				
	

}
