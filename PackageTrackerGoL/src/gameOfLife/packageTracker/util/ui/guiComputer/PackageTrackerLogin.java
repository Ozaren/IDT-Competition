/*
 * 
 */
package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.*;

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

		buttonPanel.add(new JButton("Login"), box);
		buttonPanel.add(new JButton("Sign Up"), box);
		
		add(buttonPanel);
	}

}
