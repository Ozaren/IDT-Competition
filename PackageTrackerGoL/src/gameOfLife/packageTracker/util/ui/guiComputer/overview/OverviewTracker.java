package gameOfLife.packageTracker.util.ui.guiComputer.overview;

import java.awt.*;

import javax.swing.*;

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
	      
	      gbc = creategbc(0, 0);
	      add(new JLabel("Name of Package"), gbc);
	   }
	   
	   private static GridBagConstraints creategbc(int x, int y)
	   {
		   GridBagConstraints gbc = new GridBagConstraints();
		   
		   return gbc;
	   }
}
