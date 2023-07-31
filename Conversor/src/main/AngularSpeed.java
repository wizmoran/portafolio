package main;

public class AngularSpeed extends Unit{
	public AngularSpeed(String id) {
		this.setId(id);
		this.setName(decodeName(id));
		this.setBase(decodeBase(id));
	}
	
	private String decodeName(String id) {
		
		String name;
	
		switch(id) {
		
			case "rad/s":
				name = "Radians per second";
			break;
		
			case "rpm":
				name = "Revolution per minute";
			break;
			
			default: 
				name = "Invalid angular speed";
		}
		return name;
	}
	
	private double decodeBase(String id) {
		
		double base;

		switch(id) {

			case "rad/s":
				base = 1.0;
			break;
	
			case "rpm":
				base = 0.1047198;
			break;
	
			default:
				base = 0.0;
		}
		return base;
	}
}
