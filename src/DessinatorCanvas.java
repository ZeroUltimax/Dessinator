import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DessinatorCanvas extends JPanel {

	public DessinatorCanvas() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}


	public void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	
	
}
