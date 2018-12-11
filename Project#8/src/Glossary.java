import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Glossary {

	// Glossary of the terms used in the poem titled "The Raven" by Edgar Allan Poe

	// HashMap can be used to store key-value pairs. But sometimes you may want to
	// store multiple values for the same key, what can you do then?
	// Is there any solution to that problem? Certainely, and it's eaiser that you
	// thought. To allocate more than one value to a key in java, you simply need to
	// use a list.
	// The following code snippet below shows one possible way of doing that.

	public static void main(String[] args) {

		// create a list and store values
		ArrayList<String> verbWithING = new ArrayList<String>();

		verbWithING.add("rapping");
		verbWithING.add("napping");
		verbWithING.add("tapping");
		verbWithING.add("entreating");

		ArrayList<String> obsoleteWords = new ArrayList<String>();

		obsoleteWords.add("scarce");
		obsoleteWords.add("morrow");
		obsoleteWords.add("surcease");
		obsoleteWords.add("laden");
		obsoleteWords.add("censer");
		obsoleteWords.add("fowl");

		ArrayList<String> otherWords = new ArrayList<String>();

		otherWords.add("startled");
		otherWords.add("omnious");
		otherWords.add("flit"); //
		otherWords.add("stern");
		otherWords.add("grave");
		otherWords.add("grim");

		// create a map to store keys
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		map.put("ask someone earnestly or anxiously to do something", verbWithING);
		map.put("insufficient for the demand", obsoleteWords);
		map.put("the following day", obsoleteWords);
		map.put("ending", obsoleteWords);
		map.put("heavily loaded or weighed down", obsoleteWords);
		map.put("a container in which incense is burnt during a religious ceremony", obsoleteWords);
		map.put("a bird of any type", obsoleteWords);

		map.put("gloomy and ugly", otherWords);
		map.put("to fly or move quickly and lightly", otherWords);
		map.put("severe, or showing disapproval", otherWords);

		// iterate and display values

		System.out.println("Match the definition with the corresponding word"); // match to or with?
		System.out.println();

		for (Map.Entry<String, ArrayList<String>> element : map.entrySet()) { // Set entrySet(): It is used to return a
																				// set view of the hash map.

			// The Map.entrySet method returns a collection-view of the map, whose elements
			// are of this class.

			String key = element.getKey(); // getKey() returns the key corresponding to this entry.

			ArrayList<String> values = element.getValue(); // getValue() returns the value corresponding to this entry.

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.println("\nDefinition = " + key);

			System.out.println();

			System.out.println("Words = " + values);

			System.out.println();

			System.out.print("Your answer: ");
			String answer = scanner.nextLine();

			String[] dictionary = new String[10]; // definitions

			dictionary[0] = "morrow";
			dictionary[1] = "surcease";
			dictionary[2] = "laden";
			dictionary[3] = "fowl";
			dictionary[4] = "grave";
			dictionary[5] = "censer";
			dictionary[6] = "scarse";
			dictionary[7] = "entreating";
			dictionary[8] = "flit";
			dictionary[9] = "stern";
			
			if(answer(answer,dictionary)) { // the "if" conditional invokes the answer method()
				System.out.println("\nWell done, you know the meaning of the word");
			} else {
				System.out.println("\nWhoopse, something went wrong. That's not the meaning of the word you've choosen");
			}
	

//          this.employees = new TreeMap<String,Employee>(); always sorted
//          this.employees = new HashMap<String,Employee>(); not sorted
		}
	}
	
	private static boolean answer(String answer, String[] dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			if (answer.equals(dictionary[i])) {
				return true;
			}
		}
		return false;
	}
}
