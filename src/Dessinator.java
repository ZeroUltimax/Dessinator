import java.awt.*;

import javax.swing.*;

public class Dessinator extends JFrame {

	private static final long serialVersionUID = 7683431635336021745L;
	JPanel canvas;
	
	public Dessinator() {

		super("Dessinator");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);

		this.setJMenuBar(createMenuBar());

		this.setContentPane(createContentPane());

		this.setVisible(true);

	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		{
			JMenu fileMenu = new JMenu("File");

			fileMenu.add(new JMenuItem("New"));
			fileMenu.add(new JMenuItem("Open File..."));
			fileMenu.addSeparator();
			fileMenu.add(new JMenuItem("Save"));
			fileMenu.addSeparator();
			fileMenu.add(new JMenuItem("Close"));

			menuBar.add(fileMenu);
		}
		{
			JMenu editMenu = new JMenu("Edit");

			editMenu.add(new JMenuItem("Undo"));
			editMenu.add(new JMenuItem("Redo"));
			editMenu.addSeparator();
			editMenu.add(new JMenuItem("Cut"));
			editMenu.add(new JMenuItem("Copy"));
			editMenu.add(new JMenuItem("Paste"));

			menuBar.add(editMenu);
		}
		{
			JMenu objectMenu = new JMenu("Object");

			{
				JMenu transform = new JMenu("Transform");

				transform.add(new JMenuItem("Move..."));
				transform.add(new JMenuItem("Rotate..."));
				transform.add(new JMenuItem("Reflect..."));
				transform.add(new JMenuItem("Scale..."));

				objectMenu.add(transform);
			}
			objectMenu.addSeparator();
			objectMenu.add(new JMenuItem("Group"));
			objectMenu.add(new JMenuItem("Ungroup"));

			menuBar.add(objectMenu);

		}
		{
			JMenu selectMenu = new JMenu("Select");

			selectMenu.add(new JMenuItem("All"));
			selectMenu.add(new JMenuItem("Deselect"));
			selectMenu.add(new JMenuItem("Inverse"));
			selectMenu.addSeparator();
			selectMenu.add(new JMenuItem("Next Object Above"));
			selectMenu.add(new JMenuItem("Next Object Below"));

			menuBar.add(selectMenu);

		}
		return menuBar;
	}

	private Container createContentPane() {
		JPanel contentPane = new JPanel(new BorderLayout());
		{
			JPanel centerPane = new JPanel(new BorderLayout());
			// JPanel contentPane = new JPanel(new BorderLayout());

			{
				GridLayout layout = new GridLayout(0, 2, 4 , 4);
				

				JPanel toolbar = new JPanel(layout);
				
				toolbar.add(new IconButton("Arrow Select"));
				toolbar.add(new JPanel());
				toolbar.add(new IconButton("Oval"));
				toolbar.add(new IconButton("Rectangle"));
				toolbar.add(new IconButton("Square Select"));
				toolbar.add(new IconButton("Square Select"));
				toolbar.add(new IconButton("Square Select"));
				toolbar.add(new IconButton("Square Select"));
				toolbar.add(new IconButton("Square Select"));
				toolbar.add(new IconButton("Square Select"));
				
				JPanel holder = new JPanel();

				holder.add(toolbar);

				centerPane.add(holder,BorderLayout.WEST);
			}
			{
				
				//JPanel canvasHolder = new JPanel();

				canvas = new DessinatorCanvas();
				//canvas.setPreferredSize(new Dimension(200, 200));

				//canvasHolder.add(canvas, BorderLayout.CENTER);
				
				centerPane.add(canvas/*Holder*/,BorderLayout.CENTER);
			}
			contentPane.add(centerPane, BorderLayout.CENTER);
		}
//		{
//			JPanel color = new JPanel();
//			color.add(new JColorChooser());
//			contentPane.add(color, BorderLayout.PAGE_END);
//		}

		return contentPane;
	}

	public static void main(String[] args) {
		new Dessinator();

	}

}
