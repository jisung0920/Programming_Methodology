package BankPanelUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class startBanking extends JPanel implements BankViewSetting{
	JButton createBtn;
	JTextField bankName;
	public startBanking() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
	}
	
	 public void paint(Graphics g){
		 Image image = new ImageIcon("./image/startBG.png").getImage();

		 g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		   setOpaque(false);//투명하게
		   super.paint(g);   
	}
	 
	@Override
	public void viewSetting() {
		setBackground(myColor.backgroundCol());
		
		bankName.setForeground(myColor.textCol());
		bankName.setSize(200,50);
		bankName.setLocation(400,340);
		
		createBtn.setBackground(myColor.buttonCol());
		createBtn.setSize(200,70);
		createBtn.setLocation(400,400);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueSetting() {
		bankName = new JTextField("");
		createBtn = new JButton("생성");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addToPanel() {
		// TODO Auto-generated method stub
		this.add(bankName);
		this.add(createBtn);

		
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
