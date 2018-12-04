package BankPanelUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;;

public class loginWindow extends JPanel implements BankViewSetting {
	private JButton cLoginBtn,mLoginBtn,newCustomerBtn;
	private JTextField customerId,customerPw,customerName,managerId,managerPw;
	public loginWindow() {
		setLayout(null);
		
		valueSetting();
		
		viewSetting();
		
		this.add(customerId);
		this.add(customerPw);
		this.add(customerName);
		this.add(cLoginBtn);
		this.add(newCustomerBtn);
		this.add(managerId);
		this.add(managerPw);
		this.add(mLoginBtn);
	}
	@Override
	public void viewSetting() {
		setBackground(myColor.backgroundCol());
		cLoginBtn.setSize(200,70);
		cLoginBtn.setLocation(400,350);
		mLoginBtn.setSize(80,50);
		mLoginBtn.setLocation(900,500);
		newCustomerBtn.setSize(200,70);
		newCustomerBtn.setLocation(400,420);
		
		customerId.setSize(200,50);
		customerId.setLocation(400,200);
		customerPw.setSize(200,50);
		customerPw.setLocation(400,250);
		customerName.setSize(200,50);
		customerName.setLocation(400,300);
		
		managerId.setSize(80,50);
		managerId.setLocation(900,400);
		managerPw.setSize(80,50);
		managerPw.setLocation(900,450);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueSetting() {
		// TODO Auto-generated method stub
		cLoginBtn = new JButton("로그인");
		mLoginBtn = new JButton("관리자모드");
		newCustomerBtn = new JButton("회원가입");
		
		customerId = new JTextField("ID");
		customerPw = new JTextField("PW");
		customerName = new JTextField("이름(회원가입 시)");
		
		managerId = new JTextField("관리자 ID(root)");
		managerPw = new JTextField("관리자 PW(0000)");
		
	}
	public JButton getcLoginBtn() {
		return cLoginBtn;
	}
	public void setcLoginBtn(JButton cLoginBtn) {
		this.cLoginBtn = cLoginBtn;
	}
	public JButton getmLoginBtn() {
		return mLoginBtn;
	}
	public void setmLoginBtn(JButton mLoginBtn) {
		this.mLoginBtn = mLoginBtn;
	}
	public JButton getNewCustomerBtn() {
		return newCustomerBtn;
	}
	public void setNewCustomerBtn(JButton newCustomerBtn) {
		this.newCustomerBtn = newCustomerBtn;
	}
	public JTextField getCustomerId() {
		return customerId;
	}
	public void setCustomerId(JTextField customerId) {
		this.customerId = customerId;
	}
	public JTextField getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(JTextField customerPw) {
		this.customerPw = customerPw;
	}
	public JTextField getCustomerName() {
		return customerName;
	}
	public void setCustomerName(JTextField customerName) {
		this.customerName = customerName;
	}
	public JTextField getManagerId() {
		return managerId;
	}
	public void setManagerId(JTextField managerId) {
		this.managerId = managerId;
	}
	public JTextField getManagerPw() {
		return managerPw;
	}
	public void setManagerPw(JTextField managerPw) {
		this.managerPw = managerPw;
	}
	
	
}
