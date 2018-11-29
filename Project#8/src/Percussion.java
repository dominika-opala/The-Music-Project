public class Percussion extends Instrument{
	
	public int numberOfDrums;
	
	public Percussion(String name, int warranty, int numberOfDrums) {
		super(name, warranty);
		super.warranty = warranty * numberOfDrums;
		this.numberOfDrums = numberOfDrums;
	}
	
	@Override public int priceOfInstrument(float discount) {
		int price = 150 * numberOfDrums;
		return price;
	}
	
	public String toString() {
		return "The basic information about the instrument: " + "1.name: " + getName() + " 2.warranty: " + warranty + " years " + " 3.numberOfDrums: " + numberOfDrums;

	}
	
	@Override 
	public String group() {;
		return "Percussion";
		
	}
	
	@Override 
	public String play() {
		return "A";
	}
	
}
