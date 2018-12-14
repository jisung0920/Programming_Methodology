package BankSystems;

import BankObjects.Manager;

public class BankSystem {

	public static void main(String[] args) {
		Manager manager = new Manager("root","0000");
		BankView view = new BankView();
		
		BankSystemController controller = 
				new BankSystemController(view, manager);
		
		controller.processBanking();
		
//		controller.processTransactions();
	}

}
