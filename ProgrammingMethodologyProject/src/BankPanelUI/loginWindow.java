package BankPanelUI;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;;

public class loginWindow extends BankJPanel{
	private JButton cLoginBtn,mLoginBtn,newCustomerBtn,interestBtn;
	private JTextField customerId,customerPw,customerName,managerId,managerPw;
	public loginWindow() {
		setLayout(null);
	}
	 public void paint(Graphics g){
		 URL imageURL =startBanking.class.getClassLoader().getResource("loginBG.png");
		 Image image = new ImageIcon(imageURL).getImage();

		 g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		   setOpaque(false);//투명하게
		   super.paint(g);   
	}
	@Override
	public void viewSetting() {
		setBackground(myColor.backgroundCol());
		cLoginBtn.setSize(200,50);
		cLoginBtn.setLocation(400,350);
		
		mLoginBtn.setSize(80,40);
		mLoginBtn.setLocation(900,460);
		
		newCustomerBtn.setSize(200,50);
		newCustomerBtn.setLocation(400,400);
		
		customerId.setSize(130,50);
		customerId.setLocation(470,200);
		
		customerPw.setSize(130,50);
		customerPw.setLocation(470,250);
		
		customerName.setSize(130,50);
		customerName.setLocation(470,300);
		
		managerId.setSize(80,30);
		managerId.setLocation(900,400);
		
		managerPw.setSize(80,30);
		managerPw.setLocation(900,430);
		
		
		interestBtn.setSize(50,50);
		interestBtn.setLocation(940,10);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueSetting() {
		// TODO Auto-generated method stub
		cLoginBtn = new JButton("로그인");
		mLoginBtn = new JButton("관리자모드");
		newCustomerBtn = new JButton("회원가입");
		
		customerId = new JTextField("");
		customerPw = new JTextField("");
		customerName = new JTextField("(회원가입 시)");
		
		managerId = new JTextField("root");
		managerPw = new JTextField("0000");
		
		interestBtn = new JButton("이자+");

	}
	@Override
	public void addToPanel() {
		// TODO Auto-generated method stub
		this.add(customerId);
		this.add(customerPw);
		this.add(customerName);
		this.add(cLoginBtn);
		this.add(newCustomerBtn);
		this.add(managerId);
		this.add(managerPw);
		this.add(mLoginBtn);
		this.add(interestBtn);
		
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
	public JButton getInterestBtn() {
		return interestBtn;
	}
	public void setInterestBtn(JButton interestBtn) {
		this.interestBtn = interestBtn;
	}
	
	
}
