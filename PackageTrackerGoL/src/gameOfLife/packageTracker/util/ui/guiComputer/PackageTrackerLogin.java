/*
 * 
 */
package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * The Class PackageTrackerLogin.
 */
@SuppressWarnings("serial")
public class PackageTrackerLogin extends JPanel {

	public PackageTrackerLogin() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new TitledBorder("Login"));
		
		Font inputFont = new Font("SansSerif", Font.BOLD, 20);
		
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		add(new JLabel("Username:"), box);
		
		JTextField user = new JTextField(20);
		user.setFont(inputFont);
		add(new JTextField(20), box);
		
		add(new JLabel("Password:"), box);
		add(new JPasswordField(20), box);
		
		add(new JButton("Login"), box);
		add(new JButton("Sign Up"), box);
	}

}
