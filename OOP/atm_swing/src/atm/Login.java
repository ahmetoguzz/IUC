package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Login extends JFrame {

	String pin = "1234";
	int attempts = 3;
	public Login(){
		//Basic Constructor Setup
		super("Giriş ekranı");
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250, 110);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args){
		new Login();		
	}
	
	void buildApp(){
		JLabel pinInstruction = new JLabel("Lütfen şifrenizi girin (1234)");
		JPasswordField pinText = new JPasswordField(4);
		JButton entPin = new JButton("Giriş");
		JButton quit = new JButton("Çık");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(quit);
		buttonPanel.add(entPin);
		pinText.setBackground(Color.white);
		add(pinInstruction, BorderLayout.NORTH);
		add(pinText, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}	
		});
		
		pinText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				char[] pinGuess = pinText.getPassword();
				String pinString = new String(pinGuess);
				if(pinString.equals(pin)){
					JOptionPane.showMessageDialog(null, "Doğru! Hesap açılıyor...");
					dispose();
					new ATM();
				} else{
					if(attempts != 1){
						attempts--;
						JOptionPane.showMessageDialog(null, "Şifre hatalı! \n" + attempts 
						+ " attempts remaining!");
					} else {
						JOptionPane.showMessageDialog(null, "Deneme hakkın kalmadı! \\n Çıkış yapılıyor.");
						System.exit(0);
					}
				}
			}	
		});
		entPin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				char[] pinGuess = pinText.getPassword();
				String pinString = new String(pinGuess);
				if(pinString.equals(pin)){
					JOptionPane.showMessageDialog(null, "Doğru! Hesap açılıyor...");
					dispose();
					new ATM();
				} else{
					if(attempts != 1){
						attempts--;
						JOptionPane.showMessageDialog(null, "Şifre hatalı! \n" + attempts 
						+ " deneme hakkın kaldı.!");
					} else {
						JOptionPane.showMessageDialog(null, "Deneme hakkın kalmadı! \n Çıkış yapılıyor.");
						System.exit(0);
					}
				}
			}	
		});
	}
}