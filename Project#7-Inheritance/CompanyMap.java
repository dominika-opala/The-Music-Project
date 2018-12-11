import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CompanyMap {

    Map<String,Employee> employees;
    int maxNumberOfEmployees;

    public CompanyMap(int n){
        this.employees = new TreeMap<String,Employee>();   //always sorted
        //this.employees = new HashMap<String,Employee>(); //not sorted
        this.maxNumberOfEmployees = n;
    }

    public String hire(Employee employee){
        if(employees.size() >= 100){
            return "Sorry, no open position available.";
        } else {
            if(employees.containsKey(employee.getSurname())){
                return "Employee, "+employee.getSurname()+" already exists!";
            } else {
                employees.put(employee.getSurname(),employee);
                return "Congrats, " + employee.getSurname() + " has been hired!";
            }
        }
    }

    public String fire(Employee employee){
        if(employees.containsKey(employee.getSurname())){
            employees.remove(employee.getSurname());
            return "Unfortunately, "+employee.getSurname()+" has been fired!";
        } else {
            return "Strange, "+employee.getSurname()+" does not work here!";
        }
    }


    public void display(){
        System.out.println("---------");
        for (Employee employee: employees.values()) {
            System.out.println(employee.getSurname());
        }
        System.out.println("---------");
    }


    public Employee findEmployeeBySurname(String surname) {
        for(Employee employee: employees.values()){
            if(employee.getSurname().equals(surname)){
                return employee;
            }
        }
        return null;
    }

    public String numberOfHiredEmployees() {
        int[] employed = { 0, 0 }; // the first slot represents the number of officers and the other one displays
        // the
        // number of workers
        for(Employee employee: employees.values()){
            if (employee instanceof Officer) { // The java "instanceof" operator is used to test whether the
                // object is an instance of the specified type (class or
                // subclass or interface).
                employed[0]++;
            } else {
                employed[1]++;
            }
        }

        StringBuilder string = new StringBuilder("{ ");
        for (int i = 0; i < employed.length; i++) {
            string.append(employed[i]).append(",");
        }
        return "The list of employees in the company (officers, workers): " + string + "}";
    }

    public String sumOfSalary() {
        float sumOfficer = 0;
        float sumWorker = 0;
        for(Employee employee: employees.values()){
            // Employee currentEmployee = employees[i]; FROM KRK
            if (employee instanceof Officer) {
                sumOfficer += employee.pay();
            } else if (employee instanceof Worker) {
                sumWorker += employee.pay();
            }
        }

        return "The sum of salaries earned by all the employees: " + (sumOfficer + sumWorker) + ", officers: " + sumOfficer
                + ", workers: " + sumWorker;
    }

    public void arrayList(int mode) {
        for(Employee employee: employees.values()){
            switch (mode) {
                case 1:
                    System.out.println(" " + employee.getSurname() + " , " + employee.getContract());
                    break;
                case 2:
                    System.out.println(" " + employee.getSurname() + " , " + employee.getContract() + " , "
                            + employee.group());
                    break;
                case 3:
                    System.out.println(" " + employee.getSurname() + " , " + employee.getContract() + " , "
                            + employee.group() + " , " + employee.pay());
                    break;
            }
        }
    }


    public static void main(String[] args) {

        CompanySet company = new CompanySet(100);

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

        System.out.println(company.findEmployeeBySurname("Smith"));
    }

}
