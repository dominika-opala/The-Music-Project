public class Brass extends Instrument {

	public String type;
	public static String[] LIST_OF_BRASS_INSTRUMENTS = { "saxophone", "trumpet", "trambone", "tuba" };

	public Brass(String name, int warranty, String type) {
		super(name, warranty);
		this.type = type;
	}

	@Override
	public int priceOfInstrument(float discount) {
		if (type.equals("saxophone") || type.equals("trumpet")) {
			return (int) (2000 * discount);
		} else if (type.equals("trambone")) {
			return (int) (3500 * discount);
		} else {
			return (int) (4000 * discount);
		}

	}
	
	public String toString() {
		return "The basic information about the instrument: " + "1.name: " + getName() + " 2.warranty: " + warranty + " years " + "3.type: " + type;

	}

	@Override
	public String getExtendedWarrantyTerms(float discount) {
		if (!type.equals("saxophone") && discount == 0) {
			int extendedWarranty = warranty * (int) (this.priceOfInstrument(discount) / 100);
			return "The instrument is under an extended warranty with equals: " + extendedWarranty;
		}
		return "The instrument is not under an extended warranty";
	}

	@Override
	public String group() {
		;
		return "Brass";
	}
}
