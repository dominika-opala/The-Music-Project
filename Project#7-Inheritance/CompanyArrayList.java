import java.util.ArrayList;

public class CompanyArrayList {

	private ArrayList<Employee> arrayList;

	public CompanyArrayList(int employeeNumber) {
		this.arrayList = new ArrayList<Employee>(employeeNumber);
	}

	public String hire(Employee employee) { // the object of this class will be generated in the "main" method.
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getSurname().equals(employee.getSurname())) {
				return "The person of the surname " + employee.getSurname() + " is already working for the company" ; // "return" terminates the execution of the method.
			} 
		}
		arrayList.add(employee);
		return "Hired"; // "return" terminates the execution of the method.
	}

	public String fire(Employee employee) {
		for (Employee i : arrayList) {
			if (employee.getSurname().equals(i.getSurname())) {
				arrayList.remove(employee);
				return "Fired"; // returns nothing and terminates the method execution.
			}
		}
		return "The person of the" + employee.getSurname() + " surname doesn't work in the company";
	}

	public Employee findEmployeeBySurname(String surname) {
		// znajdź Pracownika o podanym nazwisku (wynikiem powinna być referencja do
		// obiektu)
		for (int i = 0; i < arrayList.size(); i++) {
			Employee employee = arrayList.get(i);
			if (employee !=null && employee.getSurname().equals(surname)) {
				return employee;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder string = new StringBuilder("{ ");
		for (int i = 0; i < arrayList.size(); i++) {
			string.append(arrayList.get(i).getSurname()).append(" , ");
		}
		return "The list of employees in the company: " + string + "}";
	}

	public String numberOfHiredEmployees() {
		ArrayList<Integer> employed = new ArrayList<Integer>(2);
		int n = 0;
		int m = 0;
		employed.add(n);
		employed.add(m);
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) instanceof Officer) { // The java "instanceof" operator is used to test whether the
													// object is an instance of the specified type (class or
													// subclass or interface).
				n = n + 1; // increment value
				employed.set(0, n);
			} else {
				m = m + 1;
				employed.set(1, m);
			}
		}

		StringBuilder string = new StringBuilder("{ ");
		for (int i = 0; i < employed.size(); i++) {
			string.append(employed.get(i)).append(",");
		}
		return "The list of employees in the company (officers, workers): " + string + "}";

	}

	public String sumOfSalary() {
		// TODO print out a sum of all the salaries earned by officers/workers/employees
		float sumOfficer = 0;
		float sumWorker = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			// Employee currentEmployee = employees[i]; FROM KRK
			if (arrayList.get(i) instanceof Officer) {
				// We know the currentEmployee is an Officer but we need to cast it to use
				// methods from the Officer class.
				sumOfficer += arrayList.get(i).pay();
			} else if (arrayList.get(i) instanceof Worker) {
				sumWorker += arrayList.get(i).pay();
			}
		}

		return "The sum of salaries earned by all the employees: " + (sumOfficer + sumWorker) + ", officers: " + sumOfficer
				+ ", workers: " + sumWorker;
	}

	public void arrayList(int mode) { // a number from 0 - 2 that shows a desired content of the array list
		// TODO print a list of Officers/Workers (surname, contract)
		// TODO print a list of employee (surname, group, contract)
		// TODO print out a list of (surname, contract, group, salary)
		for (int i = 0; i < arrayList.size(); i++) {
			if (!arrayList.isEmpty()) {
				switch (mode) {
				case 1:
					System.out.println(" " + arrayList.get(i).getSurname() + " , " + arrayList.get(i).getContract());
					break;
				case 2:
					System.out.println(" " + arrayList.get(i).getSurname() + " , " + arrayList.get(i).getContract() + " , "
							+ arrayList.get(i).group());
					break;
				case 3:
					System.out.println(" " + arrayList.get(i).getSurname() + " , " + arrayList.get(i).getContract() + " , "
							+ arrayList.get(i).group() + " , " + arrayList.get(i).pay());
					break;
				}
			}
		}
	}
	
	public static void main(String[]args) {
		
		CompanyArrayList company = new CompanyArrayList(20);
		
		Officer smith = new Officer("Smith", 1.0f, 3000.0f, 0);
		Officer barker = new Officer("Barker", 0.5f, 1500f, 2.0f);
		Worker irving = new Worker("Irving", 1.0f, 750, 45);
		Worker major = new Worker("Major", 0.75f, 600, 60);

		System.out.println(smith.toString());
		System.out.println(barker.toString());
		System.out.println(irving.toString());
		System.out.println(major.toString());

		System.out.println(company.hire(smith));
		System.out.println(company.hire(barker));
		company.hire(irving);
		company.hire(major);
		
		System.out.println(company.toString());
		
		company.fire(irving);
		System.out.println(company.hire(major));
		
		System.out.println(company.toString());

		System.out.println(company.findEmployeeBySurname("Smith"));
		
	}
}