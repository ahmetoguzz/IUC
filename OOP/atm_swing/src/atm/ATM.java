package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ATM extends JFrame {
	int balance = 10;
	String[] inputSequence = new String[4];
	String[] transactionHist = new String[100];
	int inputSequenceIndex = 0;
	int transactionIndex = 0;
	boolean readyToEnter = false;
	public ATM(){
		super("ATM");
		for(int i =0; i <= 3; i++){
			inputSequence[i] = "";
		}
		setResizable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(600, 350);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	
	
	protected void buildApp(){
		JLabel displayArea = new JLabel("<html> Tanıtım bölümü: <br> Lütfen yapmak istediğiniz işlemi seçiniz. <br> Şimdiki bakiyeniz: TL" + balance + "</html>");
		displayArea.setOpaque(true);
		displayArea.setBackground(Color.white);
		displayArea.setPreferredSize(new Dimension(100, 100));
		JPanel bottomArea = new JPanel();
		bottomArea.setLayout(new BorderLayout(0,0));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout(0,0));
		JLabel inputDisplay = new JLabel("Giriş bölümü: ");
		inputDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomArea.add(inputDisplay, BorderLayout.NORTH);
		
		GridBagLayout buttonGrid = new GridBagLayout();
		buttonPanel.setLayout(buttonGrid);
		GridBagConstraints bPConst = new GridBagConstraints();
	
		bPConst.weightx= 0.1;
		bPConst.weighty= 0.1;
		JButton withDraw1 = new JButton("Para çek 5TL");
		bPConst.gridx = 0;
		bPConst.gridy = 0;	
		bPConst.insets = new Insets(0, 0, 5, 5);
		withDraw1.setSize(new Dimension(200, 30));
		buttonPanel.add(withDraw1, bPConst);
		JButton withDraw2 = new JButton("Para çek 10TL");
		bPConst.gridx = 0;
		bPConst.gridy = 1;
		withDraw2.setSize(new Dimension(200, 30));
		buttonPanel.add(withDraw2, bPConst);
		JButton withDraw3 = new JButton("Para çek 20TL");
		bPConst.gridx = 0;
		bPConst.gridy = 2;
		withDraw3.setSize(new Dimension(200, 30));
		buttonPanel.add(withDraw3, bPConst);
		JButton deposit = new JButton("Para yatır");
		bPConst.gridx = 0;
		bPConst.gridy = 3;
		deposit.setSize(new Dimension(200, 30));
		buttonPanel.add(deposit, bPConst);
		JButton quit = new JButton("Çıkış");
		bPConst.gridx = 0;
		bPConst.gridy = 4;
		bPConst.anchor = GridBagConstraints.PAGE_END;
		quit.setSize(new Dimension(200, 30));
		buttonPanel.add(quit, bPConst);
		JButton number1 = new JButton("1");
		bPConst.gridx = 1;
		bPConst.gridy = 0;
		number1.setSize(new Dimension(200, 30));
		buttonPanel.add(number1, bPConst);
		JButton number2 = new JButton("2");
		bPConst.gridx = 2;
		bPConst.gridy = 0;
		number2.setSize(new Dimension(200, 30));
		buttonPanel.add(number2, bPConst);
		JButton number3 = new JButton("3");
		bPConst.gridx = 3;
		bPConst.gridy = 0;
		number3.setSize(new Dimension(200, 30));
		buttonPanel.add(number3, bPConst);
		JButton number4 = new JButton("4");
		bPConst.gridx = 1;
		bPConst.gridy = 1;
		number4.setSize(new Dimension(200, 30));
		buttonPanel.add(number4, bPConst);
		JButton number5 = new JButton("5");
		bPConst.gridx = 2;
		bPConst.gridy = 1;
		number5.setSize(new Dimension(200, 30));
		buttonPanel.add(number5, bPConst);
		JButton number6 = new JButton("6");
		bPConst.gridx = 3;
		bPConst.gridy = 1;
		number6.setSize(new Dimension(200, 30));
		buttonPanel.add(number6, bPConst);
		JButton number7 = new JButton("7");
		bPConst.gridx = 1;
		bPConst.gridy = 2;
		number7.setSize(new Dimension(200, 30));
		buttonPanel.add(number7, bPConst);
		JButton number8 = new JButton("8");
		bPConst.gridx = 2;
		bPConst.gridy = 2;
		number8.setSize(new Dimension(200, 30));
		buttonPanel.add(number8, bPConst);
		JButton number9 = new JButton("9");
		bPConst.gridx = 3;
		bPConst.gridy = 2;
		number9.setSize(new Dimension(200, 30));
		buttonPanel.add(number9, bPConst);
		JButton number0 = new JButton("0");
		bPConst.gridx = 1;
		bPConst.gridy = 3;
		number0.setSize(new Dimension(200, 30));
		buttonPanel.add(number0, bPConst);
		JButton clear = new JButton("Temizle");
		bPConst.gridx = 2;
		bPConst.gridy = 3;
		clear.setSize(new Dimension(200, 30));
		buttonPanel.add(clear, bPConst);
		JButton enter = new JButton("Gir");
		bPConst.gridx = 3;
		bPConst.gridy = 3;
		enter.setSize(new Dimension(200, 30));
		buttonPanel.add(enter, bPConst);
		bottomArea.add(buttonPanel, BorderLayout.CENTER);
		add(displayArea,  BorderLayout.NORTH);
		add(bottomArea, BorderLayout.CENTER);
		
		withDraw1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(balance >= 5){
					balance = balance - 5;
					displayArea.setText("<html>5 TL Para çekildi! <br><br>" + finishedTransaction() + "</html>");
					readyToEnter = false;
					System.out.println("Kullanıcı 5 TL çekti.");
					updateTransactionHist("Kullanıcı 5 TL çekti.");
				} else {
					displayArea.setText("<html> Bakiyeniz 5 TL altında. İşlem başarısız! <br><br>" 
					+ finishedTransaction() + "</html>");
				}
			}	
		});
		withDraw2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(balance >= 10){
					balance = balance - 10;
					displayArea.setText("<html>10 TL Para çekildi! <br><br>" + finishedTransaction() + "</html>");
					readyToEnter = false;
					System.out.println("Kullanıcı 10 TL çekti.");
					updateTransactionHist("Kullanıcı 10 TL çekti.");
				} else {
					displayArea.setText("<html> Bakiyeniz 10 TL altında. İşlem başarısız! <br><br>" 
					+ finishedTransaction() + "</html>");
				}
				
			}	
		});
		withDraw3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(balance >= 20){
					balance = balance - 20;
					displayArea.setText("<html>20 TL Para çekildi! <br><br>" + finishedTransaction() + "</html>");
					readyToEnter = false;
					System.out.println("Kullanıcı 20 TL çekti.");
					updateTransactionHist("Kullanıcı 20 TL çekti.");
				} else {
					displayArea.setText("<html> Bakiyeniz 20 TL altında. İşlem başarısız! <br><br>" 
					+ finishedTransaction() + "</html>");
				}
			}	
		});
		// Quit Button - Return to login
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "İşlem geçmişi: \n" + printReceipt());
				JOptionPane.showMessageDialog(null, "Çıkış yapılıyor! Gİriş ekranına dönülüyor.!");
				dispose();
				new Login();
			}	
		});
		// Clear Button - Clear the input array (Method at bottom)
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: ");
				displayArea.setText("<html>Giriş bölümü temizlendi <br><br>" 
				+ finishedTransaction() +"</html>");
				clearInput();
				readyToEnter = false;
			}	
		});
		// Number Buttons - Add a number to the input array
		number1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("1"));
			}	
		});
		number2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("2"));
			}	
		});
		number3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("3"));
			}	
		});
		number4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("4"));
			}	
		});
		number5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("5"));
			}	
		});
		number6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("6"));
			}	
		});
		number7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("7"));
			}	
		});
		number8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("8"));
			}	
		});
		number9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("9"));
			}	
		});
		number0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Giriş bölümü: " + updateInput("0"));
			}	
		});
		deposit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
					displayArea.setText("<html> Para yatırma seçildi! <br> Yatırmak istediğiniz parayı seçin ve 'giriş' e tıklayın! <br><br>" 
					+ finishedTransaction() + "</html>" );
					readyToEnter = true;
			}	
		});
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(readyToEnter == true){
					if(Integer.parseInt(getInputSequence()) > 1000){
						displayArea.setText("Bu para 1000 TL üzerinde.");
						clearInput();
						inputDisplay.setText("Giriş bölümü: ");
						readyToEnter = false;
					} else if(Integer.parseInt(getInputSequence()) == 0 || getInputSequence().equals("0000")){
						displayArea.setText("Bir değer girmediniz.");
						clearInput();
						inputDisplay.setText("Giriş bölümü: ");
						readyToEnter = false;
					} else {
						updateBalance(Integer.parseInt(getInputSequence()));
						displayArea.setText("<html> Şu kadar para yatırdınız TL" + getInputSequence() 
						+ "! <br><br>" + finishedTransaction() + "</html>");
						System.out.println("Kullanıcı para yatırdı TL" + getInputSequence());
						updateTransactionHist("Kullanıcı para yatırdı TL" + getInputSequence());
					}
					clearInput();
					inputDisplay.setText("Giriş bölümü: ");
					readyToEnter = false;
				} else {
					displayArea.setText("<html> Bir işlem seçmediniz! <br><br>" + finishedTransaction() + "</html>");
					clearInput();
					inputDisplay.setText("Giriş bölümü: ");
				}
				
			}	
		});	
	} 

	void clearInput(){
		for(int i =0; i <= 3; i++){
			inputSequence[i] = "";	
		}
		inputSequenceIndex = 0;
	}
	String updateInput(String n){
		if(inputSequenceIndex <= 3){
			inputSequence[inputSequenceIndex] = n;
			inputSequenceIndex++;
		
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i < inputSequence.length; i++) {
				strBuilder.append(inputSequence[i]);
			}
			String newString = strBuilder.toString();
			return newString;
		} else{
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i <= 3; i++) {
				strBuilder.append(inputSequence[i]);
			}
			String newString = strBuilder.toString();
			return newString;
		}
	}
	
	String getInputSequence(){
		StringBuilder strBuilder = new StringBuilder();
		if(inputSequence[0] == ""){
			return "0000";
		} else {
			for (int i = 0; i < inputSequence.length; i++) {
				strBuilder.append(inputSequence[i]);
			}
			String newString = strBuilder.toString();
			return newString;
		}
	}
	String finishedTransaction(){
		return "Tanıtım bölümü: <br> Lütfen yapmak istediğiniz işlemi seçiniz. <br> Şimdiki bakiyeniz: TL" + balance;
	}
	void updateBalance(int l){
		balance += l;
	}
	void updateTransactionHist(String t){
		transactionHist[transactionIndex] = t;
		transactionIndex++;
	}
	//Put the final receipt together and return it for printing
	String printReceipt(){
		if(inputSequence[0].equals(null)){
			return "No Transactions Made!";
		} else{
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i < transactionIndex; i++) {
				strBuilder.append(transactionHist[i] + "\n");
			}
			String newString = strBuilder.toString();
			return newString;
	   }
	}
	public static void main (String[] args){
		new Login();	
	}
	
}

