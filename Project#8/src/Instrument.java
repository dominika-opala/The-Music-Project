public abstract class Instrument {
	
	private String name;
	protected int warranty; 
	
	public String getName() {
		return name; 
	}
	
	public int getWarranty() {
		return warranty;
	}
	
	public Instrument(String name, int warranty) {
		this.name = name;
		this.warranty = warranty;
	}
	
	public abstract int priceOfInstrument(float discount);
	
	public abstract String group();
	
	public String play() {
		return "C";
	}
	
	public String getExtendedWarrantyTerms(float discount) {
		if (!this.group().equals("Brass")); // you can use "this" with methods as well (not only instance variables)
			return "The instrument is not under an extended warranty";
	}

}
