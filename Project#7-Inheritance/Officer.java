public class Officer extends Employee{
// na płacę Urzędnika składa się płaca podstawowa wynikająca z zaszeregowania (podana dla całego etatu ) plus określony  % premii,
	
	private float basePay; 
	private float bonus; 
	
	public Officer(String surname, float contract, float basePay, float bonus) { 
		super(surname, contract); // super to metoda (konstruktora klasy nadrzednej), ktora w tym konstruktorzez iniclializuje zmienne. 
		this.basePay = basePay;
		this.bonus = bonus;
	
	}
	
	@Override public float pay() {
		float pay = (basePay + bonus * basePay) * getContract();
		return pay;
	}
	
	public String toString() {
		return "The officer's data: " + getSurname() + ", basePay: " + basePay + ", bonus: " + bonus + ", contract: " + getContract() + ", pay: " + pay();

	}

	@Override
	public String group() {
		return "officer";
	}

}