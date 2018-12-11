public class Worker extends Employee{
/*płacę Robotnika oblicza się uwzględniając liczbę przepracowanych godzin i stawkę godzinową; 
 *za nadgodziny czyli godziny przepracowane ponad LIMIT 
 *(podawany dla całego etatu i wspólny dla wszystkich Robotników ) należy się 50% dodatku.
 */
	
	public static int LIMIT = 40; // LIMIT = the max. number of hours per week that a worker can work out 
	private int rate; // rate = wage per hour
	private float hours;
	
	
	public int getRate() {
		return rate;
	}
	
	public Worker(String surname, float contract, int rate, float hours) { 
		super(surname, contract); 
		this.rate = rate;
		this.hours = hours;
		
	}
	
	@Override public float pay() {
		float extrahours = 0;
		if (hours >= LIMIT) {
			extrahours = hours - LIMIT;
			hours = LIMIT;
		} 
		float wage = (hours * rate) + (extrahours * 1.5f * rate); // f indicates that it's a float
		return wage;
	}
	
	public String toString() {
		return "The worker's data: " + getSurname() + ", rate: " + rate + ", contract: " + getContract() + ", working hours: " + hours;
	}

	@Override
	public String group() {
		return "worker";
	}
}