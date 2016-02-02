package gameOfLife.packageTracker.util.ui.guiComputer.overview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gameOfLife.packageTracker.util.ui.guiComputer.PackageTrackerFrame;

@SuppressWarnings("serial")
public class OverviewTracker extends JPanel
{
	
	
	public OverviewTracker()
	{
		Dimension dimension = new Dimension(600, 150);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		
		setLayout(new GridBagLayout());
		
		setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createEmptyBorder(0, 0, 6, 0),
						BorderFactory.createLineBorder(Color.black)));
		
		GridBagConstraints gbc;
		
		
		JButton buttonLogOut = new JButton("Log Out");
		
		buttonLogOut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			  	 ((PackageTrackerFrame) getRootPane().getParent()).showLogin();
			}
		});
		
		gbc = creategbc(2, 0);
		add(buttonLogOut, gbc);
		
		gbc = creategbc(0, 1);
		add(new JLabel("Get Package: "), gbc);
		
		gbc = creategbc(1, 1);
		add(new JTextField("uuid"), gbc);
		
		JButton buttonGetPackage = new JButton("Lookup");
		
//		buttonGetPackage.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent arg0)
//			{
//			  	 buttonGetPackage.super.actionPerformed();
//			}
//		});
		gbc = creategbc(2, 1);
		add(buttonGetPackage, gbc);
		
	}
	
	private static GridBagConstraints creategbc(int x, int y)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		
		return gbc;
	}
}
