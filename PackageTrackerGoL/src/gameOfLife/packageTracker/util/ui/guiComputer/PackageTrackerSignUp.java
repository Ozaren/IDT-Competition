/*
 * 
 */
package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The Class PackageTrackerLogin.
 * 
 * @author Jarett Lee
 */
@SuppressWarnings("serial")

public class PackageTrackerSignUp extends JPanel
{
   
   public PackageTrackerSignUp()
   {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setBorder(new CompoundBorder(new TitledBorder("Sign Up"), new EmptyBorder(10, 10, 10, 10)));
      
      Font fontInput = new Font("SansSerif", Font.PLAIN, 20);
      
      BoxLayout layoutBox = new BoxLayout(this, BoxLayout.X_AXIS);
      
      add(new JLabel("Username:"), layoutBox);
      
      JTextField fieldUser = new JTextField(20);
      fieldUser.setFont(fontInput);
      add(fieldUser, layoutBox);
      
      add(new JLabel("Password:"), layoutBox);
      
      JPasswordField passField = new JPasswordField(20);
      passField.setFont(fontInput);
      add(passField, layoutBox);
      
      JPanel panelButton = new JPanel();
      panelButton.setAlignmentX(Component.LEFT_ALIGNMENT);
      
      JButton buttonSignUp = new JButton("Sign Up");
      
      buttonSignUp.addActionListener(new ActionListener()
      {
         
         @Override
         public void actionPerformed(ActionEvent arg0)
         {
//            System.out.println("Sign up");
            ((PackageTrackerFrame) getRootPane().getParent()).showLogin();
         }
      });
      
      panelButton.add(buttonSignUp, layoutBox);
      
      KeyAdapter adapterKey = new KeyAdapter()// Sets up a key bind so that enter will click the login button
      {
         
         @Override
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               buttonSignUp.doClick();
            }
         }
      };
      
      // add login key bind
      addKeyListener(adapterKey);
      passField.addKeyListener(adapterKey);
      fieldUser.addKeyListener(adapterKey);
      panelButton.addKeyListener(adapterKey);
      buttonSignUp.addKeyListener(adapterKey);
      
      add(panelButton);
   }
   
}
