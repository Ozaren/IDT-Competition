/*
 * 
 */
package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.*;

/**
 * The Class PackageTrackerLogin.
 * 
 * @author Jarett Lee
 */
@SuppressWarnings("serial")
public class PackageTrackerLogin extends JPanel
{
   
   public PackageTrackerLogin()
   {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setBorder(new CompoundBorder(new TitledBorder("Login"), new EmptyBorder(10, 10, 10, 10)));
         
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
      
      JButton buttonLogin = new JButton("Login");
      JButton buttonSignUp = new JButton("Sign Up");
      
      buttonLogin.addActionListener(new ActionListener()
      {
         
         @Override
         public void actionPerformed(ActionEvent arg0)
         {
            System.out.println("Login");
         }
      });
      
      buttonSignUp.addActionListener(new ActionListener()
      {
         
         @Override
         public void actionPerformed(ActionEvent arg0)
         {
            System.out.println("Sign up");
         }
      });
      
      panelButton.add(buttonLogin, layoutBox);
      panelButton.add(buttonSignUp, layoutBox);
      
      buttonSignUp.addKeyListener(new KeyAdapter()// Sets up a key bind so that enter will click the signup button
      {
         @Override
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               buttonSignUp.doClick();
            }
         }
      });
      
      KeyAdapter adapterKey = new KeyAdapter()// Sets up a key bind so that enter will click the login button
      {
         
         @Override
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               buttonLogin.doClick();
            }
         }
      };
      
      // add login key bind
      addKeyListener(adapterKey);
      passField.addKeyListener(adapterKey);
      fieldUser.addKeyListener(adapterKey);
      buttonLogin.addKeyListener(adapterKey);
      panelButton.addKeyListener(adapterKey);
      
      add(panelButton);
   }
   
}
