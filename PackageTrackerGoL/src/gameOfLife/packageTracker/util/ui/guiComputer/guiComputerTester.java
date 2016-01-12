package gameOfLife.packageTracker.util.ui.guiComputer;

import javax.swing.SwingUtilities;

/**
 * 
 * @author Jarett Lee
 *
 */
public class guiComputerTester {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new PackageTrackerFrame();
            }
        });

	}

}
