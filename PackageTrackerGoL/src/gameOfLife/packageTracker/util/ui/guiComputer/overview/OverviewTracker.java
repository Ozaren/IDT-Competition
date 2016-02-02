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
	      
	      gbc = creategbc(3, 0);
	      JButton buttonLogOut = new JButton("Log Out");
	      
	      buttonLogOut.addActionListener(new ActionListener()
	      {
	         
	         @Override
	         public void actionPerformed(ActionEvent arg0)
	         {
	        	 ((PackageTrackerFrame) getRootPane().getParent()).showLogin();
	         }
	      });
	      
	      add(buttonLogOut, gbc);
	      
	      gbc = creategbc(0, 3);
	      add(new JLabel("get Package: "), gbc);

	      gbc = creategbc(1, 3);
	      add(new JTextField("uuid"), gbc);
	   }
	   
	   private static GridBagConstraints creategbc(int x, int y)
	   {
		   GridBagConstraints gbc = new GridBagConstraints();
		   gbc.gridx = x;
		   gbc.gridy = y;
		   
		   return gbc;
	   }
	   
	   
}
