import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class IconButton extends JPanel {

	JButton button;
	
	public IconButton(String iconName) {
		super();
		this.setLayout(new GridLayout());
		button = new JButton(getIcon(iconName));
		button.setPreferredSize(new Dimension(26,26));
		
		this.add(button);
	}

	private ImageIcon getIcon(String fileName) {
		String fullName = fileName + ".png";
		URL imageURL = this.getClass().getResource(fullName);

		try {
			Image img = ImageIO.read(imageURL);
			return new ImageIcon(img);
		} catch (IOException ex) {
			return null;
		}

	}
	
	

}
