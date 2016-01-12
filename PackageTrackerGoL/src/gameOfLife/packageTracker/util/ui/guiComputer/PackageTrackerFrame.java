package gameOfLife.packageTracker.util.ui.guiComputer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The Class PackageTrackerFrame. Contains every other GUI component in the
 * project.
 * 
 * @author Jarett Lee
 */
@SuppressWarnings("serial")
public class PackageTrackerFrame extends JFrame
{
   
   public PackageTrackerFrame()
   {
      setTitle("Title");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel content = (JPanel) getContentPane();
      content.setBorder(new EmptyBorder(20, 20, 20, 20));
      
      add(new PackageTrackerLogin());
      pack();
      setVisible(true);
   }
}
