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
   JPanel packageListView;
   
   public PackageTrackerOverview()
   {
      Dimension dimension = new Dimension(600, 600);
      setSize(dimension);
      setPreferredSize(dimension);
      setMinimumSize(dimension);
      setMaximumSize(dimension);
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      add(new OverviewTracker());
      
      packageListView = new JPanel();
      packageListView.setLayout(new BoxLayout(packageListView, BoxLayout.Y_AXIS));
      JScrollPane packageList = new JScrollPane(packageListView);
      
      loadPackageListComp();
      
      add(packageList);
      
      
   }
   
   public void loadPackageListComp()
   {
	   packageListView.add(new JPanelOverviewElement());
	   packageListView.add(new JPanelOverviewElement());
	   packageListView.add(new JPanelOverviewElement());
	   packageListView.add(new JPanelOverviewElement());
	   packageListView.add(new JPanelOverviewElement());
   }
}
