package main;

public class Currency extends Unit {

	public Currency(String id) {
		this.setId(id);
		this.setName(decodeName(id));
		this.setBase(decodeBase(id));
	}
	
	private String decodeName(String id) {
		
		String name;
	
		switch(id) {
		
		case "MXN":
			name = "Mexican Peso";
		break;
	
		case "USD":
			name = "United States Dollar";
		break;
	
		case "EUR":
			name = "Euro";
		break;
	
		case "JPY":
			name = "Japanese Yen";
		break;
	
		case "COP":
			name = "Colombian Peso";
		break;
	
		case "GBP":
			name = "British Pound Sterlin";
		break;
	
		case "KRW":
			name = "Korean Won Sul";
		break;
	
		case "ARS":
			name = "Argentine Peso";
		break;
		
		default: 
			name= "Invalid currency";
	
		}
		
		return name;
		
	}
	
		private double decodeBase(String id) {
	
			double base;

			switch(id) {
	
			case "MXN":
				base = 0.05878895;
			break;

			case "USD":
				base = 1.0;
			break;

			case "EUR":
				base = 1.09;
			break;

			case "JPY":
				base = 0.00692425;
			break;
		
			case "COP":
				base = 0.00024215;
			break;
		
			case "GBP":
				base = 1.27;
			break;
		
			case "KRW":
				base = 0.00076634;
			break;
		
			case "ARS":
				base = 0.00385253;
			break;
		
			default:
				base = 0.0;
			}
			return base;
	}
	

}
