package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The Class PackageTrackerFrame. Contains every other GUI component in the project.
 * 
 * @author Jarett
 */
@SuppressWarnings("serial")
public class PackageTrackerFrame extends JFrame
{
	
	public PackageTrackerFrame () {
		setTitle("Title");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel(new GridBagLayout());
		content.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		setContentPane(content);

		add(new PackageTrackerLogin());
		
		pack();
		setVisible(true);
	}
}
