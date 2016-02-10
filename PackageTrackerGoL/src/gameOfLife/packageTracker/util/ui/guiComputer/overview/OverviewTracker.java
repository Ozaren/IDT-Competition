package gameOfLife.packageTracker.util.ui.guiComputer.overview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import gameOfLife.packageTracker.util.ui.guiComputer.PackageTrackerFrame;

@SuppressWarnings("serial")
public class OverviewTracker extends JPanel {

	public OverviewTracker() {

		setLayout(new GridBagLayout());

		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0),
				BorderFactory.createLineBorder(Color.black)));

		JLabel title = new JLabel("Package Tracker");
		title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 48));
		// Dimension titleDimen = new Dimension(400, 64);
		// title.setPreferredSize(titleDimen);
		// title.setMaximumSize(titleDimen);
		// title.setMinimumSize(new Dimension(300, 26));
		title.setHorizontalAlignment(JLabel.CENTER);
		// Log Out Button

		JButton buttonLogOut = new JButton("Log Out");

		buttonLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((PackageTrackerFrame) getRootPane().getParent()).showLogin();
			}
		});

		JLabel labelGet = new JLabel("Get Package: ");
		labelGet.setMaximumSize(new Dimension(50, 26));
		labelGet.setHorizontalAlignment(JLabel.RIGHT);

		JButton buttonGetPackage = new JButton("Lookup");
		
		/*
		buttonGetPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO
			}
		});
		KeyAdapter adapterKey = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buttonGetPackage.doClick();
				}
			}
		};
		buttonGetPackage.addKeyListener(adapterKey);
		*/

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		
		// label get package
		c.weightx = 0.5;
		c.insets = new Insets(0, 25, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		add(labelGet, c);

		// textfield uuid
		c.weightx = 0.7;
		c.insets = new Insets(0, 0, 0, 0);
		c.ipadx = 140;
		c.gridx = 1;
		c.gridy = 2;
		add(new JTextField("uuid"), c);

		// button get
		c.weightx = 0.5;
		c.insets = new Insets(0, 0, 0, 50);
		c.ipadx = 0;
		c.gridx = 2;
		c.gridy = 2;
		add(buttonGetPackage, c);

		// button logout
		c.anchor = GridBagConstraints.NORTHEAST;
		c.insets = new Insets(0, 0, 0, 0);
		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 0;
		add(buttonLogOut, c);

		// label Package Tracker
		c.anchor = GridBagConstraints.NORTHWEST;
		c.insets = new Insets(0, 0, 10, 0);
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		add(title, c);

		setMinimumSize(getPreferredSize());
	}

	// private static GridBagConstraints creategbc(int x, int y) {
	// GridBagConstraints gbc = new GridBagConstraints();
	// gbc.gridx = x;
	// gbc.gridy = y;
	// if (y == 0 || x == 0) {
	// gbc.weightx = 0.0;
	// gbc.weighty = 0.0;
	// gbc.fill = GridBagConstraints.NONE;
	// }
	//
	// return gbc;
	// }
}
