import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicStore {

	private ArrayList<Instrument> list;

	public MusicStore(int numberOfInstrumentsInStore) {
		this.list = new ArrayList<Instrument>(numberOfInstrumentsInStore);
	}

	public ArrayList<Instrument> getAll() {
		return list;
	}

	public void display(float discount) {
		
		System.out.println();
		System.out.println("Which of the information types would you like to learn about the instruments available in the store?");
		System.out.println();
		System.out.println("1: {name, category, tuning note}");
		System.out.println("2: {name, category, price}");
		System.out.println("3: {name, price, discount, warranty}");
		System.out.println();
		System.out.println("Enter a desired number: ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println();

		if (!list.isEmpty() && 0 < number && number <= 3) {
			for (int i = 0; i < list.size(); i++) {
				switch (number) {
				case 1:
					System.out.println(""+(i+1)+". {name: " + list.get(i).getName() + " , category: " + list.get(i).group()
							+ " , tuning note: " + list.get(i).play() + " }");
					break;
				case 2:
					System.out.println(""+(i+1)+". {name: " + list.get(i).getName() + " , category: " + list.get(i).group()
							+ " , price: " + list.get(i).priceOfInstrument(discount) + " }");
					break;
				case 3:
					System.out.println(""+(i+1)+". {name: " + list.get(i).getName() + " , price: "
							+ list.get(i).priceOfInstrument(discount) + " , discount: " + discount + " , warranty: "
							+ list.get(i).warranty + " }");
					break;
				}
					
			}
			
		} else {
			System.out.println("You entered a wrong number!");  
			System.out.println();
		}

	}
	

	public void add(Instrument instrument) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == instrument) {
				return;
			}
		}
		list.add(instrument);
	}

	public void remove(Instrument instrument) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(instrument.getName())) {
				list.remove(instrument);
			}
		}
	}

	public boolean inquiry(String name) {
		for (Instrument instrument : list) {
			if (instrument.getName().equals(name)) {
				return true;
			}
		}
		return false;

	}

	public int numberOfInstrumentsInTheList(String group) { // What is wrong with this method?
		int counter = 0;
		System.out.println(group);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).group().equals(group)) {
				counter++;
			}
		}
		return counter;
	}

	static void tune(Instrument instrument) {
		instrument.play();
	}

	static void tuneAll(List<Instrument> instruments) {
		for (Instrument instrument : instruments)
			tune(instrument);
	}

	public static void main(String[] args) {

		MusicStore musicalInstruments = new MusicStore(100);

		Brass silverTramboneI = new Brass("trambone", 5, "silverTrambone");
		Brass silverTramboneII = new Brass("trambone", 5, "silverTrambone");
		Brass gildedTrambone = new Brass("trambone", 10, "gildedTrambone");
		Brass trumpet = new Brass("trumpet", 5, "trumpet");

		Woodwind silverFlute = new Woodwind("flute", 5, "silverFlute");
		Woodwind woodenFlute = new Woodwind("flute", 2, "woodenFlute");
		Woodwind bassoon = new Woodwind("bassoon", 10, "bassoon");

		Percussion tambourine = new Percussion("tambourine", 2, 1);
		Percussion percussionSet = new Percussion("percussionSet", 15, 5);
		Percussion bassDrum = new Percussion("bassDrum", 10, 1);

		System.out.println(bassoon.toString()); 
		System.out.println(bassDrum.toString()); 
		System.out.println(woodenFlute.toString()); 
		
		musicalInstruments.add(silverTramboneII);
		musicalInstruments.add(bassoon);
		musicalInstruments.add(silverFlute);
		musicalInstruments.add(gildedTrambone);
		musicalInstruments.add(trumpet);

		musicalInstruments.display(0.25f);

		musicalInstruments.remove(silverTramboneI);
		musicalInstruments.add(woodenFlute);
		musicalInstruments.remove(silverFlute);
		musicalInstruments.add(bassDrum);

		musicalInstruments.add(percussionSet);
		musicalInstruments.add(tambourine);

		musicalInstruments.display(0.30f);
		
		System.out.println();
		
		System.out.println(musicalInstruments.inquiry("saxophone"));
		System.out.println(musicalInstruments.inquiry("bassoon"));
		
		System.out.println();

		System.out.println(musicalInstruments.numberOfInstrumentsInTheList("Percussion")); 
		System.out.println(musicalInstruments.numberOfInstrumentsInTheList("Brass"));
		System.out.println(musicalInstruments.numberOfInstrumentsInTheList("Woodwind"));

		MusicStore.tune(gildedTrambone);
		MusicStore.tune(percussionSet);

		MusicStore.tuneAll(musicalInstruments.getAll());

	}
}