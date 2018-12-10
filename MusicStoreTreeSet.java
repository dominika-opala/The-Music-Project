import java.util.*;
public class MusicStoreTreeSet {
	
	// Instead of accessing the elements in the set by using an index, we use an Iterator to do so.
	// An Iterator is an object that has two methods: hasNext() - returns {@code true} if the iteration has more elements - and next() - returns the next element in the iteration.
	
	private SortedSet<Instrument> treeSet;

	public MusicStoreTreeSet() {
		this.treeSet = Collections.synchronizedSortedSet(new TreeSet<Instrument>());
	}

	public SortedSet<Instrument> getAll() {
		return treeSet;
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

		if (!treeSet.isEmpty() && 0 < number && number <= 3) {
			int i = 1;
			for (Instrument item: treeSet) {
				switch (number) {
				case 1:
					System.out.println(""+i+". {name: " + item.getName() + " , category: " + item.group()
							+ " , tuning note: " + item.play() + " }");
					break;
				case 2:
					System.out.println(""+i+". {name: " + item.getName() + " , category: " + item.group()
							+ " , price: " + item.priceOfInstrument(discount) + " }");
					break;
				case 3:
					System.out.println(""+i+". {name: " + item.getName() + " , price: "
							+ item.priceOfInstrument(discount) + " , discount: " + discount + " , warranty: "
							+ item.warranty + " }");
					break;
				}
				i++;	
			}
			
		} else {
			System.out.println("You entered a wrong number!");  
			System.out.println();
		}

	}
	

	public void add(Instrument instrument) {
		for (Instrument item: treeSet) {
			if (item.equals(instrument)) {
				return;
			}
		}
		treeSet.add(instrument);
	}

	public void remove(Instrument instrument) {
		for (Instrument item: treeSet) {
			if (item.getName().equals(instrument.getName())) {
				treeSet.remove(instrument);
			}
		}
	}

	public boolean inquiry(String name) {
		for (Instrument item : treeSet) {
			if (item.getName().equals(name)) {
				return true;
			}
		}
		return false;

	}
	
	public boolean ifContains(Instrument instrument) {
		return treeSet.contains(instrument);

	}

	public int numberOfInstrumentsInTheList(String group) { // What is wrong with this method?
		int counter = 0;
		System.out.println(group);
		for (Instrument item : treeSet) {
			if (item.group().equals(group)) {
				counter++;
			}
		}
		return counter;
	}
	
	public void storeClearance() {
		treeSet.clear();
	}
	
	public int numberOfAllInstrumentsInStock() {
		return treeSet.size();
	}

	static void tune(Instrument instrument) {
		instrument.play();
	}

	static void tuneAll(Set<Instrument> instruments) {
		for (Instrument instrument : instruments)
			tune(instrument);
	}
	
	public static void main(String[] args) {
		
		MusicStoreTreeSet musicalInstruments = new MusicStoreTreeSet();

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

		MusicStoreTreeSet.tune(gildedTrambone);
		MusicStoreTreeSet.tune(percussionSet);

		MusicStoreTreeSet.tuneAll(musicalInstruments.getAll());
	}
}


