package gameOfLife.packageTracker.util.ui.guiComputer.overview;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JPanelOverviewElement extends JPanel {
	
	Package packr;
	JLabel labelName;
	JLabel labelUUID;
	JLabel labelStatus;
	JLabel labelETA;
	
	public JPanelOverviewElement() {
		Dimension dimension = new Dimension(574, 150);
	    setPreferredSize(dimension);
	    setMaximumSize(dimension);
		setLayout(new GridBagLayout());
		
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(3, 5, 3, 5),
				BorderFactory.createLineBorder(Color.black)));
		
		GridBagConstraints gbc;
		
		gbc = creategbc(0, 0);
		labelName = new JLabel("Name of Package");
		add(labelName, gbc);
		
		gbc = creategbc(0, 1);
		labelUUID = new JLabel("UUID: ");
		add(labelUUID, gbc);
		
		gbc = creategbc(0, 2);
		labelStatus = new JLabel("Status: ");
		add(labelStatus, gbc);
		
		gbc = creategbc(0, 4);
		labelETA = new JLabel("ETA: ");
		add(labelStatus, gbc);
	}
		 
	private static GridBagConstraints creategbc(int x, int y)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		
		return gbc;
	}
	
	public void setName(String name)
	{
		labelName.setText(name);
	}
	
	public void setStatus(String stat)
	{
		labelStatus.setText("Status: " + stat);
	}
	
	public void setUUID(String uuid)
	{
		labelUUID.setText("UUID: " + uuid);
	}
	
	public void setETA(String eta)
	{
		labelETA.setText("ETA: " + eta);
	}
	
}
