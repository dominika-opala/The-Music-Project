import java.util.Arrays;
import java.util.Comparator;

public class Company {
	
	// 7b. Co i jak należy zmienić aby uwzględnić wymaganie, że tablica Pracowników powinna być uporządkowana
	// według nazwisk Pracowników? Wprowadź odpowiednie zmiany --> which feature (hashset, hashmap, arrayList, array) would be best to resolve the problem?
	

	private Employee[] employees;

	public Company(int n) {
		if(n <= 100){ 
			employees = new Employee[n]; 
		} else {
			employees = new Employee[100];
			 }
	}

	/* każdy Pracownik jest jednoznacznie identyfikowany przez nazwisko (nazwisko jest pełnym
	 * identyfikatorem więc nie może być dwóch Pracowników o tym samym nazwisku).
	 */
	
	public void hire(Employee employee) { // the object of this class will be generated in the "main" method.
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) { // && !employees[i].getSurname().equals(employee.getSurname())
				employees[i] = employee;
				Arrays.sort(employees, Comparator.nullsLast(Comparator.comparing(Employee::getSurname)));
				return; // "return" terminates the execution of the method.
			}
		}
	}

	public void fire(Employee employee) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSurname().equals(employee.getSurname())) {
				employees[i] = null;
				return; // returns nothing and terminates the method execution.
			}
		}
	}

	public String toString() {
		String string = "{ ";
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null) {
				string += employees[i].getSurname() + ", ";
			}
		}
		return "The list of employees in the company: " + string + "}";
	}

	public Employee callingEmployeeBySurname(Employee employee) {
		// znajdź Pracownika o podanym nazwisku (wynikiem powinna być referencja do
		// obiektu)
		for (int i = 0; i < employees.length; i++) {
			if (employees[i]!=null && employees[i].getSurname().equals(employee.getSurname())) {
				return employee;
			}
		}
		throw null;
	}

	public String numberOfHiredEmployees() {
		int[] employed = { 0, 0 }; // the first slot represents the number of officers and the other one displays
									// the
									// number of workers
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null) {
				if (employees[i] instanceof Officer) { // The java "instanceof" operator is used to test whether the
														// object is an instance of the specified type (class or
														// subclass or interface).
					employed[0]++;
				} else {
					employed[1]++;
				}
			}
		}

		String string = "{ ";
		for (int i = 0; i < employed.length; i++) {
			string += employed[i] + ",";
		}
		return "The list of employees in the company (officers, workers): " + string + "}";

	}

	public String sumOfSalary() {
		// TODO print out a sum of all the salaries earned by officers/workers/employees
		float sumEmployee = 0;
		float sumOfficer = 0;
		float sumWorker = 0;
		for (int i = 0; i < employees.length; i++) {
			// Employee currentEmployee = employees[i]; FROM KRK
			if (employees[i] instanceof Officer) {
				// We know the currentEmployee is an Officer but we need to cast it to use
				// methods from the Officer class.
				sumOfficer += ((Officer) employees[i]).pay();
				sumEmployee += ((Officer) employees[i]).pay();
			} else if (employees[i] instanceof Worker) {
				sumWorker += ((Worker) employees[i]).pay();
				sumEmployee += ((Worker) employees[i]).pay();
			}
		}

		return "The sum of salaries earned by all the employees: " + sumEmployee + ", officers: " + sumOfficer
				+ ", workers: " + sumWorker;
	}

	public void arrayList(int mode) { // a number from 0 - 2 that shows a desired content of the array list
		// TODO print a list of Officers/Workers (surname, contract)
		// TODO print a list of employee (surname, group, contract)
		// TODO print out a list of (surname, contract, group, salary)
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null) {
				switch (mode) {
				case 1:
					System.out.println(" " + employees[i].getSurname() + " , " + employees[i].getContract());
					break;
				case 2:
					System.out.println(" " + employees[i].getSurname() + " , " + employees[i].getContract() + " , "
							+ employees[i].group());
					break;
				case 3:
					System.out.println(" " + employees[i].getSurname() + " , " + employees[i].getContract() + " , "
							+ employees[i].group() + " , " + employees[i].pay());
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

		Company company = new Company(20);

		Officer smith = new Officer("Smith", 1.0f, 3000.0f, 0);
		Officer barker = new Officer("Barker", 0.5f, 1500f, 2.0f);
		Worker irving = new Worker("Irving", 1.0f, 750, 45);
		Worker major = new Worker("Major", 0.75f, 600, 60);

		System.out.println(smith.toString());
		System.out.println(barker.toString());
		System.out.println(irving.toString());
		System.out.println(major.toString());

		company.hire(smith);
		company.hire(barker);
		company.hire(irving);
		company.hire(major);

		System.out.println();

		System.out.println(company.toString());
		company.fire(major);
		System.out.println();
		System.out.println(company.toString());
		System.out.println();
		System.out.println(company.numberOfHiredEmployees());

		System.out.println(company.sumOfSalary());
		System.out.println();
		company.arrayList(3);

		System.out.println();
		company.arrayList(2);
		
		company.callingEmployeeBySurname(smith);
	}
}