package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * 
 * @author Jarett Lee
 *        
 */
@SuppressWarnings("serial")
public class PackageTrackerOverview extends JPanel
{
   public PackageTrackerOverview()
   {
      Dimension dimension = new Dimension(600, 600);
      setSize(dimension);
      setPreferredSize(dimension);
      setMinimumSize(dimension);
      setMaximumSize(dimension);
   }
}
