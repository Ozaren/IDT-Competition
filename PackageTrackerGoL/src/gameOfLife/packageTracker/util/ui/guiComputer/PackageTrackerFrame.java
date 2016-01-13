package gameOfLife.packageTracker.util.ui.guiComputer;

import java.awt.GridBagLayout;

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
	PackageTrackerLogin loginPanel;
	PackageTrackerOverview overviewPanel;
	PackageTrackerDetal detailPanel;
	
	public PackageTrackerFrame () {
		setTitle("Title");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel content = new JPanel(new GridBagLayout());
		
		content.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		setContentPane(content);
		
		loginPanel = new PackageTrackerLogin();
		overviewPanel = new PackageTrackerOverview();
		detailPanel = new PackageTrackerDetal();
		
		addLogin();
		
		setVisible(true);
	}
	
	public void removeCurrent() {
		if (loginPanel.getParent() == this) remove(loginPanel);
		if (overviewPanel.getParent() == this) remove(overviewPanel);
		if (detailPanel.getParent() == this) remove(detailPanel);
	}
	
	public void addLogin() {
		removeCurrent();
		add(loginPanel);
	}
	
	public void addOverview() {
		removeCurrent();
		add(overviewPanel);
	}
	
	public void addDetail() {
		removeCurrent();
		add(detailPanel);
	}
}
