package BankSystems;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import BankPanelUI.createAccount;
import BankPanelUI.customerMain;
import BankPanelUI.loginWindow;
import BankPanelUI.managerMain;
import BankPanelUI.myColor;
import BankPanelUI.startBanking;
import BankPanelUI.useAccount;

public class BankView extends JFrame{
	
	private int width = 1000;
	private int height = 600;
	
	private startBanking start;
	private loginWindow login;
	private managerMain manage;
	private customerMain custom;
	private createAccount createA;
	private useAccount userA;
	
	
	public BankView() {
		// TODO Auto-generated constructor stub
		initPanel();
		setTitle("Bank");
		setSize(width, height);
		setBackground(myColor.backgroundCol());
		
		add(start); 
		setVisible(true);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	void initPanel() {
		start = new startBanking();
		login = new loginWindow();
		
		
	}
	void startTologin() {
		getContentPane().removeAll();
		getContentPane().add(login);
		revalidate();
		repaint();
	}
	void loginTomanage() {
		getContentPane().removeAll();
		getContentPane().add(manage);
		revalidate();
		repaint();
	}
	void loginTocustom() {
		getContentPane().removeAll();
		getContentPane().add(custom);
		revalidate();
		repaint();
	}
	void customTocreate() {
		getContentPane().removeAll();
		getContentPane().add(createA);
		revalidate();
		repaint();
		
	}
	void customTouse() {
		getContentPane().removeAll();
		getContentPane().add(userA);
		revalidate();
		repaint();
	}

	public startBanking getStart() {
		return start;
	}

	public void setStart(startBanking start) {
		this.start = start;
	}

	public loginWindow getLogin() {
		return login;
	}

	public void setLogin(loginWindow login) {
		this.login = login;
	}

	public managerMain getManage() {
		return manage;
	}

	public void setManage(managerMain manage) {
		this.manage = manage;
	}

	public customerMain getCustom() {
		return custom;
	}

	public void setCustom(customerMain custom) {
		this.custom = custom;
	}

	public createAccount getCreateA() {
		return createA;
	}

	public void setCreateA(createAccount createA) {
		this.createA = createA;
	}

	public useAccount getUserA() {
		return userA;
	}

	public void setUserA(useAccount userA) {
		this.userA = userA;
	}

}