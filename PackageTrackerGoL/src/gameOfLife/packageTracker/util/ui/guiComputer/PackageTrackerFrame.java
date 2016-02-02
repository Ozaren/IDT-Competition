package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameOfLife.packageTracker.util.ui.guiComputer.overview.PackageTrackerOverview;

/**
 * The Class PackageTrackerFrame. Contains every other GUI component in the
 * project.
 * 
 * @author Jarett Lee
 */
@SuppressWarnings("serial")
public class PackageTrackerFrame extends JFrame
{
   private JPanel panelLogin, panelOverview, panelDetail , panelSignUp;
   
   public PackageTrackerFrame()
   {
      setTitle("Title");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel content = (JPanel) getContentPane();
      content.setLayout(new GridBagLayout());
      content.setBorder(new EmptyBorder(20, 20, 20, 20));
      
      panelLogin = new PackageTrackerLogin();
      panelOverview = new PackageTrackerOverview();
      panelDetail = new PackageTrackerDetail();
      panelSignUp = new PackageTrackerSignUp();
      
      showLogin();
      
      setVisible(true);
   }
   
   public void removeCurrent()
   {
      if(panelLogin.getParent() == getContentPane())
         remove(panelLogin);
      if(panelOverview.getParent() == getContentPane())
         remove(panelOverview);
      if(panelDetail.getParent() == getContentPane())
         remove(panelDetail);
      if(panelSignUp.getParent() == getContentPane())
         remove(panelSignUp);
   }
   
   public void swapMain(JPanel panel)
   {
      removeCurrent();
      add(panel);
      pack();
      repaint();
   }
   
   public void showLogin()
   {
      swapMain(panelLogin);
   }
   
   public void showOverview()
   {
      swapMain(panelOverview);
   }
   
   public void showDetail()
   {
      swapMain(panelDetail);
   }

   public void showSignUp()
   {
      swapMain(panelSignUp);
   }
}
