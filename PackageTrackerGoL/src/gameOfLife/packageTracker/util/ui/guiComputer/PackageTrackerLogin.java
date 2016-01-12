/*
 * 
 */
package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * The Class PackageTrackerLogin.
 * 
 * @author Jarett Lee
 */
@SuppressWarnings("serial")
public class PackageTrackerLogin extends JPanel {

	public PackageTrackerLogin() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new CompoundBorder(new TitledBorder("Login"), new EmptyBorder(10,10,10,10)));
		
		Font inputFont = new Font("SansSerif", Font.PLAIN, 20);
		
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		
		add(new JLabel("Username:"), box);
		
		JTextField userField = new JTextField(20);
		userField.setFont(inputFont);
		add(userField, box);
		
		add(new JLabel("Password:"), box);
		
		JTextField passField = new JTextField(20);
		passField.setFont(inputFont);
		add(passField, box);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed");
				if(getParent() instanceof PackageTrackerFrame) {
					System.out.println("instance");
					PackageTrackerFrame frame = (PackageTrackerFrame) getParent();
					// TODO cause the button the switch views
					frame.addOverview();
				}
	    	}
		});
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed");
	    	}
		});
		
		
		buttonPanel.add(loginBtn, box);
		buttonPanel.add(signUpBtn, box);
		
		add(buttonPanel);
	}

}
