package main;

public abstract class Unit {
	
	private String id;
	private String name;
	private double base;
		
	
	public Unit() {
		
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "[" + id + "] " + name;
		
	}
	
	

}
