package gameOfLife.packageTracker.util.ui.guiComputer.overview;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JPanelOverviewElement extends JPanel {
	
	public JPanelOverviewElement() {
		Dimension dimension = new Dimension(600, 150);
	    setPreferredSize(dimension);
	    setMaximumSize(dimension);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc;
		
		gbc = creategbc(0, 0);
		add(new JLabel("Name of Package"), gbc);
		
		gbc = creategbc(0, 1);
		add(new JLabel("UUID: "), gbc);
		
		gbc = creategbc(0, 2);
		add(new JLabel("status: "), gbc);
	}
		 
	private static GridBagConstraints creategbc(int x, int y)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		 
		return gbc;
	}
}
