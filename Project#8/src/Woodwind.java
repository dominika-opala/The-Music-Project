public class Woodwind extends Instrument {

	public String type;
	public static String[] LIST_OF_WOODWIND_INSTRUMENTS = {"flute", "bassoon", "clarnet"}; // static means that it's not a property of the object but of the class;
	
	public Woodwind(String name, int warranty, String type) {
		super(name, warranty);
		this.type = type;
	}
	
	@Override 
	public int priceOfInstrument(float discount) {
		if (type.equals("flute") || type.equals("clarnet")) {
			return (int)(1100 * discount);
		} else {
			return (int)(1500 * discount);
		}
	}
	
	public String toString() {
		return "The basic information about the instrument: " + "1.name: " + getName() + " 2.warranty: " + warranty + " years " +  "3.type: " + type;

	}
	
	@Override 
	public String group() {
		return "Woodwind";
	}
}
