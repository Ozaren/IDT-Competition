package gameOfLife.packageTracker.util.ui.guiComputer.overview;

import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author Jarett Lee
 *        
 */
@SuppressWarnings("serial")
public class PackageTrackerOverview extends JPanel
{
   JScrollPane packageList;
   
   public PackageTrackerOverview()
   {
      Dimension dimension = new Dimension(600, 600);
      setSize(dimension);
      setPreferredSize(dimension);
      setMinimumSize(dimension);
      setMaximumSize(dimension);
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      add(new OverviewTracker());
      
      packageList = new JScrollPane();
      add(packageList);
      
      
   }
}
