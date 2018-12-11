public abstract class Employee { // abstract means that I can't create a direct object of this class
	// you need to specify what sort of employee that is (either an officer or a worker).
	
	private String surname; 

	private float contract; // contract = workperiod
	
	// If I initilized contract as "protected" instead of "private," I wouldn't have to use the getContract method in subclasses.
	
//	public setSurname() { it's redundant because we are not going to change the surnames of employees
//		this.surname = surname;
//	}
//	
	public String getSurname() { // Here we're asking about a surname of an employee
		return surname;
	}
	
	public float getContract() {
		return contract;
	}
	
	public Employee(String surname, float contract) {
		this.surname = surname;
		this.contract = contract;
	}
	
	public abstract float pay();

	public abstract String group();
}