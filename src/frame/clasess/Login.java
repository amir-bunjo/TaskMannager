package frame.clasess;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;

public class Login extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	//iskomentarisat kasnije sluzi da bi se trenutno mogla testirat
//	public static void main(String[] args) {
//		try {
//			Login dialog = new Login();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( textField.getText().equals("admin") && isPasswordCorrect(passwordField.getPassword())) {
					TaskerMain taskerMain = new TaskerMain();
					taskerMain.setVisible(true);
					
					dispose();
				}else {
					System.out.println(textField.getText());
					JOptionPane.showMessageDialog(null, "Wrong username or password! Try again");

				}
				
			}
		});
		btnNewButton.setBounds(185, 186, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(185, 87, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(86, 74, 89, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(86, 130, 72, 23);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 130, 89, 24);
		getContentPane().add(passwordField);
		
		JLabel lblTaskerLogin = new JLabel("Tasker Login");
		lblTaskerLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTaskerLogin.setBounds(159, 21, 102, 37);
		getContentPane().add(lblTaskerLogin);
	}
	
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 'a', 'd', 'm', 'i', 'n' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
}
