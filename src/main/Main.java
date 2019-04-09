package main;

import javax.swing.JDialog;

import frame.clasess.Login;

public class Main {
	
	
	// Main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
