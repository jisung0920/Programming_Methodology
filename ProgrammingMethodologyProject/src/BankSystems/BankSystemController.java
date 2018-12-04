package BankSystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BankObjects.Bank;
import BankObjects.Customer;
import BankObjects.Manager;
import BankPanelUI.loginWindow;

public class BankSystemController {

	private BankView view;
	private Manager bankManager;
	
	public BankSystemController(BankView view, Manager manager) {
		this.view  =	view;
		this.bankManager = manager;

	}

	public void setButtonAction() {
		view.getStart().getCreateBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String bankName = view.getStart().getBankName().getText();
				view.setTitle(bankName);
				bankManager.makeBank(bankName);
				view.startTologin();
			}
		});	
		
		loginWindow login = view.getLogin();
		login.getcLoginBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Bank bank = bankManager.getBank();
//				bank.hasId(id)
				
			}
		});
		
		login.getNewCustomerBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Bank bank = bankManager.getBank();
				Customer customer = new Customer(view.getLogin().getCustomerId().getText(),view.getLogin().getCustomerPw().getText(),view.getLogin().getCustomerName().getText());
				bank.getCustomers().add(customer);
	
			}
		});
		login.getmLoginBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = login.getManagerId().getText();
				String pw = login.getManagerPw().getText();
				System.out.println(id+"/"+pw);
				if(bankManager.login(id, pw))
					view.loginTomanage();
				else
					System.out.println("wrong");
			}
		});
		
	}
}
