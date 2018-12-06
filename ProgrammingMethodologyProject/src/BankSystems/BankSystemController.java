package BankSystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BankObjects.Account;
import BankObjects.Bank;
import BankObjects.Customer;
import BankObjects.DepositAccout;
import BankObjects.Manager;
import BankObjects.NormalAccount;
import BankObjects.WithdrawAccount;
import BankPanelUI.customerMain;
import BankPanelUI.loginWindow;
import BankPanelUI.managerMain;
import BankPanelUI.startBanking;

public class BankSystemController {

	private BankView view;
	private Manager bankManager;
	private int customerIdx,accountIdx;
	
	public BankSystemController(BankView view, Manager manager) {
		this.view  = view;
		this.bankManager = manager;
		customerIdx=0;
		accountIdx =0;

	}
	public void processBanking() {
		startBanking start = new startBanking();
		setStartBanking(start);
		view.attachPanel(start);
//		view.setLogin();
	}
	
	public void setStartBanking(startBanking panel) {
		this.view.setStart(panel);
		panel.valueSetting();
		panel.viewSetting();
		panel.addToPanel();
		panel.getCreateBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String bankName = panel.getBankName().getText();
				view.setTitle(bankName);
				bankManager.makeBank(bankName);
				setLoginWindow(new loginWindow());
				view.goTologin();
			}
		});	
	}
	public void setLoginWindow(loginWindow panel) {
		this.view.setLogin(panel);
		panel.valueSetting();
		panel.viewSetting();
		panel.addToPanel();
		panel.getcLoginBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Bank bank = bankManager.getBank();
				ArrayList<Customer> customer = bank.getCustomers();
				String id,pw;
				id = panel.getCustomerId().getText();
				pw = panel.getCustomerPw().getText();

				for(int i=0;i<customer.size();i++) {
					if(customer.get(i).identifyCustomer(id, pw)) {
						customerIdx = i;
						customerMain c = new customerMain();
						setCustomerMain(c);
						view.setCustom(c);
						view.goTocustom();
//						setCustomerMain(new customerMain());
						return ;
					}
				}
				JOptionPane.showMessageDialog(panel, "아이디와 패스워드를 확인하세요.","로그인 실패",JOptionPane.WARNING_MESSAGE);
				
				
			}
		});
		
		panel.getNewCustomerBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Bank bank = bankManager.getBank();
				String id =view.getLogin().getCustomerId().getText();
				String pw = view.getLogin().getCustomerPw().getText();
				String name = view.getLogin().getCustomerName().getText();
				
				if(bank.hasId(id)) 
					JOptionPane.showMessageDialog(panel, "동일한 아이디가 있습니다. ","가입 실패",JOptionPane.WARNING_MESSAGE);

				else if(id.length()<4 || pw.length()<4) 
					JOptionPane.showMessageDialog(panel, "아이디와 패스워드는 4자 이상으로 설정해주세요. ","가입 실패",JOptionPane.WARNING_MESSAGE);

				else if(!InputProcesser.isString(name)) 
					JOptionPane.showMessageDialog(panel, "이름은 문자로만 구성되어야 합니다. ","가입 실패",JOptionPane.WARNING_MESSAGE);
				
				else {
					JOptionPane.showMessageDialog(panel, name+"님 회원가입이 되었습니다.","가입 성공",JOptionPane.PLAIN_MESSAGE);
					Customer customer = new Customer(id,pw,name);
					bank.getCustomers().add(customer);
				}
			}
		});
		
		panel.getmLoginBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = panel.getManagerId().getText();
				String pw = panel.getManagerPw().getText();
				if(bankManager.login(id, pw)) {
					setManagerMain(new managerMain());
					view.goTomanage();
				}
				else
					JOptionPane.showMessageDialog(panel, "아이디와 패스워드를 확인하세요.","관리자 로그인 실패",JOptionPane.WARNING_MESSAGE);
				
			}
		});
	}
	public void setManagerMain(managerMain panel) {
		this.view.setManage(panel);
		panel.valueSetting(this.bankManager.getBank());
		panel.viewSetting();
		panel.addToPanel();
		
		panel.getSettingBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String chargeStr = panel.getChargeValue().getText();
				String interestStr = panel.getInterestValue().getText();
				if(InputProcesser.isInt(chargeStr)&& InputProcesser.isNumber(interestStr)) {
					int charge = Integer.parseInt(panel.getChargeValue().getText());
					float interest = Float.parseFloat(panel.getInterestValue().getText());
					bankManager.getBank().setCharge(charge);
					bankManager.getBank().setInterest(interest);
					JOptionPane.showMessageDialog(panel, "설정되었습니다.","설정 성공",JOptionPane.PLAIN_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(panel, "설정값을 정확하게 입력해주세요.","설정 성공",JOptionPane.WARNING_MESSAGE);

			}
		});
		panel.getBackBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.goTologin();
			}
		});
		panel.getUsrDeleteBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int delIndex = panel.getUserList().getSelectedIndex();
				if(delIndex == -1) {
					JOptionPane.showMessageDialog(panel,"선택된 고객이 없습니다.","삭제 실패",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					bankManager.getBank().getCustomers().remove(delIndex);
					panel.getUserList().setListData(bankManager.getBank().getCustomersName().toArray());
					JOptionPane.showMessageDialog(panel,"선택된 고객이 삭제되었습니다.","삭제 성공",JOptionPane.PLAIN_MESSAGE);	

				}// TODO Auto-generated method stub
				
				
			}
		});
	}

	public void setCustomerMain(customerMain panel) {
//		panel = new customerMain();
		this.view.setCustom(panel);
		panel.valueSetting(bankManager.getBank().getCustomers().get(customerIdx),bankManager.getBank());
		panel.viewSetting();
		panel.addToPanel();
		System.out.println("setsasdfas");
//		panel.getAccountList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getAccountId().toArray());
		panel.getBackBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				view.getCustom().removeAccList();
				
				view.goTologin();
			}
		});
		
		panel.getCreateAccountBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer customer = bankManager.getBank().getCustomers().get(customerIdx);
				String id = customer.getName().length()*customer.getId().length()*999%1000+"-"+(System.currentTimeMillis()/100)%100000;
				customer.getAccounts().add(new NormalAccount(id));
				
				JOptionPane.showMessageDialog(panel, id+" 번호의 계좌가 생성되었습니다. ","계좌 생성 ",JOptionPane.PLAIN_MESSAGE);
				panel.getAccountList().setListData(customer.getAccountId().toArray());
				panel.getTransactionList().setListData(bankManager.getBank().getAllAccountName().toArray());
				
			}
		});
		
		panel.getSelectBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selIndex = panel.getAccountList().getSelectedIndex();
				accountIdx = selIndex;
				if(accountIdx==-1) {
					JOptionPane.showMessageDialog(panel,"선택된 계좌가 없습니다.");
					return ;
				}
				Account account = bankManager.getBank().getCustomers().get(customerIdx).getAccounts().get(selIndex);
				panel.getAccountLabel().setText(account.getAccountId());
				panel.getBalanceLabel().setText("잔액 : " + account.getBalance());
				System.out.println(account.getAccountId());
			}
		});
		
		panel.getDeleteBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int delIndex = panel.getAccountList().getSelectedIndex();
				if(accountIdx == delIndex) {
					JOptionPane.showMessageDialog(panel,"현재 사용중인 계좌는 삭제할 수 없습니다. ","삭제 실패",JOptionPane.WARNING_MESSAGE);
					
				}
				else if(delIndex == -1) {
					JOptionPane.showMessageDialog(panel,"선택된 계좌가 없습니다.","삭제 실패",JOptionPane.WARNING_MESSAGE);
					
				}
				else {
					Customer customer = bankManager.getBank().getCustomers().get(customerIdx);
					customer.getAccounts().remove(delIndex);
					panel.getAccountList().setListData(customer.getAccountId().toArray());
					accountIdx--;
				}// TODO Auto-generated method stub
				
			}
		});
		
		panel.getDepositBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(panel.getAccountLabel().getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "계좌가 선택되지 않았습니다.","출금 실패",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				Account account = bankManager.getBank().getCustomers().get(customerIdx).getAccounts().get(accountIdx);
				String balanceStr = panel.getAmountValue().getText();
				if(InputProcesser.isInt(balanceStr)&&account.depositAccount(Integer.parseInt(balanceStr))) {
					panel.getBalanceLabel().setText("잔액 : " + account.getBalance());					
					JOptionPane.showMessageDialog(panel,balanceStr+"이 입금되었습니다.","입금 완료",JOptionPane.PLAIN_MESSAGE);
					panel.getAccountList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getAccountId().toArray());
					panel.gettList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getCustomerTransaction().toArray());
				}
				else
					JOptionPane.showMessageDialog(panel, "계좌나 금액을 확인해 주세요.","입금 실패",JOptionPane.WARNING_MESSAGE);

				
			}
		});
		
		panel.getWithdrawBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(panel.getAccountLabel().getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "계좌가 선택되지 않았습니다.","출금 실패",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				Account account = bankManager.getBank().getCustomers().get(customerIdx).getAccounts().get(accountIdx);
				String balanceStr = panel.getAmountValue().getText();
				
				if(InputProcesser.isInt(balanceStr) && balanceStr.length()<10) {
					int charge=bankManager.getBank().getCharge();
					int value = Integer.parseInt(balanceStr)+charge;
					if(!account.withdrawAccount(value)) {
						JOptionPane.showMessageDialog(panel, "계좌나 잔액을 확인해 주세요.","출금 실패",JOptionPane.WARNING_MESSAGE);
						return ;
					}
					panel.getBalanceLabel().setText("잔액 : " + account.getBalance());					
					JOptionPane.showMessageDialog(panel,value+"이 출금되었습니다.\n수수료 : "+charge,"출금 완료",JOptionPane.PLAIN_MESSAGE);
					panel.getAccountList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getAccountId().toArray());
					panel.gettList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getCustomerTransaction().toArray());
				}
				else
					JOptionPane.showMessageDialog(panel, "금액을 정확하게 입력해주세요.\n한도 : 1억원 ","출금 실패",JOptionPane.WARNING_MESSAGE);

			}
		});
		
		panel.gettransferBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String toAccountName = (String) panel.getTransactionList().getSelectedValue();
				if(panel.getAccountLabel().getText().equals("")||toAccountName==null) {
					JOptionPane.showMessageDialog(panel, "계좌가 선택되지 않았습니다.","이체 실패",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				Account account = bankManager.getBank().getCustomers().get(customerIdx).getAccounts().get(accountIdx);
				Account toAccount = bankManager.getBank().getAccount(toAccountName);
				String balanceStr = panel.getAmountValue().getText();
				if(InputProcesser.isInt(balanceStr) && balanceStr.length()<10) {
					int charge=bankManager.getBank().getCharge();
					int value = Integer.parseInt(balanceStr);
					if(!account.transfeAccount(toAccount, value,charge)) {
						JOptionPane.showMessageDialog(panel, "계좌나 잔액을 확인해 주세요.","이체 실패",JOptionPane.WARNING_MESSAGE);
						return ;
					}
					panel.getBalanceLabel().setText("잔액 : " + account.getBalance());					
					JOptionPane.showMessageDialog(panel,value+"이 출금되었습니다.\n수수료 : "+charge,"이체 완료",JOptionPane.PLAIN_MESSAGE);
					panel.getAccountList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getAccountId().toArray());
					panel.gettList().setListData(bankManager.getBank().getCustomers().get(customerIdx).getCustomerTransaction().toArray());
					
				}
				else
					JOptionPane.showMessageDialog(panel, "금액을 정확하게 입력해주세요.\n한도 : 1억원 ","이체 실패",JOptionPane.WARNING_MESSAGE);

				
			}
			
		});
		
		panel.getCreDAccountBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer customer = bankManager.getBank().getCustomers().get(customerIdx);
				String id = customer.getName().length()*customer.getId().length()*999%1000+"-"+(System.currentTimeMillis()/100)%100000;
				customer.getAccounts().add(new DepositAccout(id));
				
				JOptionPane.showMessageDialog(panel, id+" 번호의 적금용 계좌가 생성되었습니다. ","계좌 생성 ",JOptionPane.PLAIN_MESSAGE);
				panel.getAccountList().setListData(customer.getAccountId().toArray());
				panel.getTransactionList().setListData(bankManager.getBank().getAllAccountName().toArray());
				
			}
		});
		
		panel.getCreWAccountBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer customer = bankManager.getBank().getCustomers().get(customerIdx);
				String id = customer.getName().length()*customer.getId().length()*999%1000+"-"+(System.currentTimeMillis()/100)%100000;
				customer.getAccounts().add(new WithdrawAccount(id));
				
				JOptionPane.showMessageDialog(panel, id+" 번호의 출금 계좌가 생성되었습니다. ","계좌 생성 ",JOptionPane.PLAIN_MESSAGE);
				panel.getAccountList().setListData(customer.getAccountId().toArray());
				panel.getTransactionList().setListData(bankManager.getBank().getAllAccountName().toArray());
				
				
			}
		});
	}
	

}
