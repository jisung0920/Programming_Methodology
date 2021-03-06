package BankPanelUI;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BankObjects.Bank;

public class managerMain extends BankJPanel{

	private JLabel settingLabel,chargeLabel,interestLabel,userListLabel,tranListLabel;
	private JTextField chargeValue,interestValue;
	private JButton settingBtn,backBtn,usrDeleteBtn;
	private JList userList,transactionList;
	
	public managerMain() {
		setLayout(null);
	}
	 public void paint(Graphics g){
		 URL imageURL =startBanking.class.getClassLoader().getResource("customBG.png");
		 Image image = new ImageIcon(imageURL).getImage();

		 g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		   setOpaque(false);//투명하게
		   super.paint(g);   
	}
	@Override
	public void viewSetting() {
		// TODO Auto-generated method stub
		setBackground(myColor.backgroundCol());
		
		backBtn.setSize(70,40);
		backBtn.setLocation(10,10);
		
		settingLabel.setSize(50,50);
		settingLabel.setLocation(90,100);
		
		chargeLabel.setSize(50,50);
		chargeLabel.setLocation(90,200);
		
		interestLabel.setSize(50,50);
		interestLabel.setLocation(90,250);
		
		userListLabel.setSize(50,50);
		userListLabel.setLocation(400,100);
		
		settingBtn.setSize(200,50);
		settingBtn.setLocation(80,310);
		
		chargeValue.setSize(150,50);
		chargeValue.setLocation(130,200);
		
		interestValue.setSize(150,50);
		interestValue.setLocation(130,250);
		
		userList.setSize(230,600);
		userList.setLocation(350,150);
		
		tranListLabel.setSize(50,50);
		tranListLabel.setLocation(610,100);
		
		transactionList.setSize(400,600);
		transactionList.setLocation(610,150);
		
		usrDeleteBtn.setSize(100,30);
		usrDeleteBtn.setLocation(470,110);
	}

	@Override
	public void valueSetting() {
		chargeLabel = new JLabel("수수료");
		interestLabel = new JLabel("이자율");
		userListLabel = new JLabel("고객 명단");
		backBtn = new JButton("뒤로가기");
		chargeValue = new JTextField();
		interestValue = new JTextField();
		settingBtn = new JButton("설정");
		userList = new JList<String>();
		transactionList = new JList();
		settingLabel = new JLabel("설정");
		tranListLabel = new JLabel("거래내역");
		usrDeleteBtn = new JButton("고객 삭제");
		// TODO Auto-generated method stub
		
	}
	public void valueSetting(Bank bank) {
		
		chargeLabel = new JLabel("수수료");
		interestLabel = new JLabel("이자율");
		userListLabel = new JLabel("고객 명단");
		backBtn = new JButton("뒤로가기");
		chargeValue = new JTextField(bank.getCharge()+"");
		interestValue = new JTextField(bank.getInterest()+"");
		settingBtn = new JButton("설정");
		settingLabel = new JLabel("설정");
		tranListLabel = new JLabel("거래내역");
		usrDeleteBtn = new JButton("고객 삭제");
		userList = new JList(bank.getCustomersName().toArray());
		transactionList = new JList(bank.getAllTranscation().toArray());
	}
	@Override
	public void addToPanel() {
		// TODO Auto-generated method stub
		this.add(chargeLabel);
		this.add(interestLabel);
		this.add(userListLabel);
		this.add(chargeValue);
		this.add(interestValue);
		this.add(settingBtn);
		this.add(userList);
		this.add(backBtn);
		this.add(transactionList);
		this.add(settingLabel);
		this.add(tranListLabel);
		this.add(usrDeleteBtn);
	}

	public JLabel getChargeLabel() {
		return chargeLabel;
	}

	public void setChargeLabel(JLabel chargeLabel) {
		this.chargeLabel = chargeLabel;
	}

	public JLabel getInterestLabel() {
		return interestLabel;
	}

	public void setInterestLabel(JLabel interestLabel) {
		this.interestLabel = interestLabel;
	}

	public JLabel getUserListLabel() {
		return userListLabel;
	}

	public void setUserListLabel(JLabel userListLabel) {
		this.userListLabel = userListLabel;
	}

	public JTextField getChargeValue() {
		return chargeValue;
	}

	public void setChargeValue(JTextField chargeValue) {
		this.chargeValue = chargeValue;
	}

	public JTextField getInterestValue() {
		return interestValue;
	}

	public void setInterestValue(JTextField interestValue) {
		this.interestValue = interestValue;
	}

	public JButton getSettingBtn() {
		return settingBtn;
	}

	public void setSettingBtn(JButton settingBtn) {
		this.settingBtn = settingBtn;
	}

	public JList getUserList() {
		return userList;
	}

	public void setUserList(JList userList) {
		this.userList = userList;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}
	public JLabel getSettingLabel() {
		return settingLabel;
	}
	public void setSettingLabel(JLabel settingLabel) {
		this.settingLabel = settingLabel;
	}
	public JLabel getTranListLabel() {
		return tranListLabel;
	}
	public void setTranListLabel(JLabel tranListLabel) {
		this.tranListLabel = tranListLabel;
	}
	public JButton getUsrDeleteBtn() {
		return usrDeleteBtn;
	}
	public void setUsrDeleteBtn(JButton usrDeleteBtn) {
		this.usrDeleteBtn = usrDeleteBtn;
	}
	public JList getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(JList transactionList) {
		this.transactionList = transactionList;
	}

	
}
