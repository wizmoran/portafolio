package main;

public class LinearSpeed extends Unit{

	public LinearSpeed(String id) {
		this.setId(id);
		this.setName(decodeName(id));
		this.setBase(decodeBase(id));
	}
	
private String decodeName(String id) {
		
		String name;
	
		switch(id) {
		
		case "m/s":
			name = "Meter per second";
		break;
	
		case "km/h":
			name = "Kilometer per hour";
		break;
	
		case "mi/h":
			name = "Mile per hour";
		break;
	
		case "ft/s":
			name = "Feet per second";
		break;
	
		case "knot":
			name = "Nautical mile";
		break;
		default:
			name="Invalid linear speed";
	
		}
		
		return name;
		
	}
	
		private double decodeBase(String id) {
	
			double base;

			switch(id) {
	
			case "m/s":
				base = 1.0;
			break;

			case "km/h":
				base = 0.277778;
			break;

			case "mi/h":
				base = 0.44704;
			break;

			case "ft/s":
				base = 0.3048;
			break;
		
			case "knot":
				base = 0.514444;
			break;
		
			default:
				base = 0.0;
			}
			return base;
	}
}
