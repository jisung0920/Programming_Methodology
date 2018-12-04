package BankPanelUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class startBanking extends JPanel implements BankViewSetting{
	JButton createBtn;
	JTextField bankName;
	public startBanking() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		valueSetting();

		viewSetting();
		
		this.add(bankName);
		this.add(createBtn);

	}
	@Override
	public void viewSetting() {
		setBackground(myColor.backgroundCol());
		
		bankName.setForeground(myColor.textCol());
		bankName.setSize(200,50);
		bankName.setLocation(400,300);
		
		createBtn.setBackground(myColor.buttonCol());
		createBtn.setSize(200,70);
		createBtn.setLocation(400,400);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueSetting() {
		bankName = new JTextField("은행이름");
		createBtn = new JButton("생성");
		// TODO Auto-generated method stub
		
	}
	public JButton getCreateBtn() {
		return createBtn;
	}
	public void setCreateBtn(JButton createBtn) {
		this.createBtn = createBtn;
	}
	public JTextField getBankName() {
		return bankName;
	}
	public void setBankName(JTextField bankName) {
		this.bankName = bankName;
	}
	
	

}