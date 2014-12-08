package dessinator;

import java.awt.*;

import javax.swing.*;

import Controller.DessinatorController;
import java.util.Map;
import java.util.TreeMap;

public class Dessinator extends JFrame {

	private static final long serialVersionUID = 7683431635336021745L;
	private DessinatorCanvas canvas;

	private Map<String, IconButton> toolbarButtons;

	private IconButton activeButton;

	public Dessinator(DessinatorController dessinatorController) {

		super("Dessinator");

		toolbarButtons = new TreeMap<>();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);

		this.setJMenuBar(createMenuBar(dessinatorController));

		this.setContentPane(createContentPane(dessinatorController));

		this.setVisible(true);

	}

	private JMenuBar createMenuBar(DessinatorController dessinatorController) {
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

				transform.add(new JMenuItem(dessinatorController.getAction("Move")));
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

	private Container createContentPane(
			DessinatorController dessinatorController) {
		JPanel contentPane = new JPanel(new BorderLayout());
		{
			JPanel centerPane = new JPanel(new BorderLayout());
			// JPanel contentPane = new JPanel(new BorderLayout());

			{
				GridLayout layout = new GridLayout(0, 2, 4, 4);

				JPanel holder = new JPanel();

				holder.add(createToolbar(layout, dessinatorController));

				centerPane.add(holder, BorderLayout.WEST);
			}
			{

				// JPanel canvasHolder = new JPanel();
				canvas = new DessinatorCanvas(dessinatorController);
				// canvas.setPreferredSize(new Dimension(200, 200));

				// canvasHolder.add(canvas, BorderLayout.CENTER);
				centerPane.add(getCanvas() /* Holder */ , BorderLayout.CENTER);
			}
			contentPane.add(centerPane, BorderLayout.CENTER);
		}
		// {
		// JPanel color = new JPanel();
		// color.add(new JColorChooser());
		// contentPane.add(color, BorderLayout.PAGE_END);
		// }

		return contentPane;
	}

	private JPanel createToolbar(GridLayout layout, DessinatorController dessinatorController) {
		JPanel toolbar = new JPanel(layout);

		addIconButton(toolbar, "Arrow Select", dessinatorController);
		toolbar.add(new JPanel());
		addIconButton(toolbar, "Oval", dessinatorController);
		addIconButton(toolbar, "Rectangle", dessinatorController);

		return toolbar;
	}

	private void addIconButton(JPanel toolbar, String iconName, DessinatorController controller) {
		IconButton result = new IconButton(iconName, controller);

		toolbarButtons.put(iconName, result);
		toolbar.add(result);
	}

	public void setActiveButton(String button) {

		if (this.activeButton != null && this.activeButton.getName() != button) {
			this.activeButton.setActive(false);
		}

		this.activeButton = toolbarButtons.get(button);
		this.activeButton.setActive(true);

	}

	public DessinatorCanvas getCanvas() {
		return canvas;
	}

}
