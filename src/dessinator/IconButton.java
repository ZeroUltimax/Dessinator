package dessinator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class IconButton extends JPanel {

	private JButton button;
	private String iconName;

	public IconButton(String iconName, ActionListener listener) {
		super();
		this.setLayout(new GridLayout());
		button = new JButton(getIcon(iconName));
		button.setPreferredSize(new Dimension(26, 26));
		button.setActionCommand(iconName);
		button.addActionListener(listener);
		this.add(button);
		this.iconName = iconName;
	}

	private ImageIcon getIcon(String fileName) {
		String fullName = "icons/" + fileName + ".png";
		URL imageURL = this.getClass().getClassLoader().getResource(fullName);

		try {
			Image img = ImageIO.read(imageURL);
			return new ImageIcon(img);
		} catch (IOException ex) {
		} catch (IllegalArgumentException e) {
		}
		return null;
	}

	public String getIconName() {
		return iconName;
	}

	void setActive(boolean active) {
		if (active) {
			this.setBorder(BorderFactory.createBevelBorder(0));
		} else {
			this.setBorder(BorderFactory.createEmptyBorder());
		}
		repaint();
	}
}
