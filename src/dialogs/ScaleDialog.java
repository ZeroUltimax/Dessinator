package dialogs;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JToggleButton;

import java.awt.GridBagConstraints;

import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Insets;

import javax.swing.ImageIcon;

import java.awt.Toolkit;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;


public class ScaleDialog extends JDialog {

	private final JPanel scaleTypePanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner HSpinner;
	private JSpinner VSpinner;
	private SpinnerNumberModel percentSpinnerModel =
			new SpinnerNumberModel(new Integer(100), new Integer(0), null, new Integer(1));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ScaleDialog dialog = new ScaleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ScaleDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ScaleDialog.class.getResource("/icons/ScaleIcon.png")));
		setTitle("Scale");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		JPanel Content = new JPanel();
		Content.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(Content);
		getContentPane().setLayout(new BorderLayout());
		scaleTypePanel.setLayout(new FlowLayout());
		scaleTypePanel.setBorder(new EmptyBorder(5, 15, 5, 15));
		getContentPane().add(scaleTypePanel, BorderLayout.NORTH);
		
		{
			JLabel lblScaleBy = new JLabel("Scale by:");
			scaleTypePanel.add(lblScaleBy);
		}
		{
			JRadioButton rdbtnPercentage = new JRadioButton("Percentage");
			rdbtnPercentage.setSelected(true);
			buttonGroup.add(rdbtnPercentage);
			scaleTypePanel.add(rdbtnPercentage);
		}
		{
			JRadioButton rdbtnPixels = new JRadioButton("Pixels");
			rdbtnPixels.setEnabled(false);
			buttonGroup.add(rdbtnPixels);
			scaleTypePanel.add(rdbtnPixels);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton scaleButton = new JButton("Scale");
				scaleButton.setActionCommand("OK");
				buttonPane.add(scaleButton);
				getRootPane().setDefaultButton(scaleButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel centerPanel = new JPanel();
			getContentPane().add(centerPanel, BorderLayout.CENTER);
			centerPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel linkPanel = new JPanel();
				linkPanel.setBorder(new EmptyBorder(0, 0, 0, 15));
				centerPanel.add(linkPanel, BorderLayout.EAST);
				GridBagLayout gbl_linkPanel = new GridBagLayout();
//				gbl_linkPanel.columnWidths = new int[]{0, 0};
//				gbl_linkPanel.rowHeights = new int[]{0, 0};
//				gbl_linkPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//				gbl_linkPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				linkPanel.setLayout(gbl_linkPanel);
				{
					final JToggleButton tglbtnScaleLink = new JToggleButton("");
					ImageIcon ScaleLinked = new ImageIcon(ScaleDialog.class.getResource("/icons/LinkedScale.png"));
					ImageIcon ScaleUnlinked = new ImageIcon(ScaleDialog.class.getResource("/icons/UnlinkedScale.png"));
					tglbtnScaleLink.setIcon(ScaleUnlinked);
					tglbtnScaleLink.setSelectedIcon(ScaleLinked);
					tglbtnScaleLink.setSelected(true);
					tglbtnScaleLink.setBorderPainted(false);
					tglbtnScaleLink.setPreferredSize(new Dimension(22,22));
					GridBagConstraints gbc_tglbtnScaleLink = new GridBagConstraints();
					gbc_tglbtnScaleLink.gridx = 0;
					gbc_tglbtnScaleLink.gridy = 0;
					linkPanel.add(tglbtnScaleLink, gbc_tglbtnScaleLink);
				}
			}
			{
				JPanel optionsPanel = new JPanel();
				optionsPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
				centerPanel.add(optionsPanel, BorderLayout.CENTER);
				GridBagLayout gbl_optionsPanel = new GridBagLayout();
//				gbl_optionsPanel.columnWidths = new int[]{125, 125, 125, 0};
//				gbl_optionsPanel.rowHeights = new int[]{92, 92, 0};
//				gbl_optionsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
//				gbl_optionsPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				optionsPanel.setLayout(gbl_optionsPanel);
				{
					JLabel lblHArrow = new JLabel("");
					lblHArrow.setIcon(new ImageIcon(ScaleDialog.class.getResource("/icons/HArrow.png")));
					GridBagConstraints gbc_lblHArrow = new GridBagConstraints();
					gbc_lblHArrow.anchor = GridBagConstraints.EAST;
					gbc_lblHArrow.fill = GridBagConstraints.VERTICAL;
					gbc_lblHArrow.insets = new Insets(0, 0, 5, 5);
					gbc_lblHArrow.gridx = 0;
					gbc_lblHArrow.gridy = 0;
					optionsPanel.add(lblHArrow, gbc_lblHArrow);
				}
				{
					JLabel lblHorizontal = new JLabel("Horizontal:");
					GridBagConstraints gbc_lblHorizontal = new GridBagConstraints();
					gbc_lblHorizontal.anchor = GridBagConstraints.EAST;
					gbc_lblHorizontal.fill = GridBagConstraints.VERTICAL;
					gbc_lblHorizontal.insets = new Insets(0, 0, 5, 5);
					gbc_lblHorizontal.gridx = 1;
					gbc_lblHorizontal.gridy = 0;
					optionsPanel.add(lblHorizontal, gbc_lblHorizontal);
				}
				{
					JPanel panel = new JPanel();
					GridBagConstraints gbc_panel = new GridBagConstraints();
					gbc_panel.fill = GridBagConstraints.BOTH;
					gbc_panel.insets = new Insets(0, 0, 5, 0);
					gbc_panel.gridx = 2;
					gbc_panel.gridy = 0;
					optionsPanel.add(panel, gbc_panel);
					panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					{
						HSpinner = new JSpinner();
						HSpinner.setModel(percentSpinnerModel);
						HSpinner.setPreferredSize(new Dimension(50,23));
						panel.add(HSpinner);
					}
				}
				{
					JLabel lblVArrow = new JLabel("");
					lblVArrow.setIcon(new ImageIcon(ScaleDialog.class.getResource("/icons/VArrow.png")));
					GridBagConstraints gbc_lblVArrow = new GridBagConstraints();
					gbc_lblVArrow.anchor = GridBagConstraints.EAST;
					gbc_lblVArrow.fill = GridBagConstraints.VERTICAL;
					gbc_lblVArrow.insets = new Insets(0, 0, 0, 5);
					gbc_lblVArrow.gridx = 0;
					gbc_lblVArrow.gridy = 1;
					optionsPanel.add(lblVArrow, gbc_lblVArrow);
				}
				{
					JLabel lblVertical = new JLabel("Vertical:");
					GridBagConstraints gbc_lblVertical = new GridBagConstraints();
					gbc_lblVertical.anchor = GridBagConstraints.EAST;
					gbc_lblVertical.fill = GridBagConstraints.VERTICAL;
					gbc_lblVertical.insets = new Insets(0, 0, 0, 5);
					gbc_lblVertical.gridx = 1;
					gbc_lblVertical.gridy = 1;
					optionsPanel.add(lblVertical, gbc_lblVertical);
				}
				{
					JPanel panel = new JPanel();
					GridBagConstraints gbc_panel = new GridBagConstraints();
					gbc_panel.fill = GridBagConstraints.BOTH;
					gbc_panel.gridx = 2;
					gbc_panel.gridy = 1;
					optionsPanel.add(panel, gbc_panel);
					{
						VSpinner = new JSpinner();
						VSpinner.setModel(percentSpinnerModel);
						VSpinner.setPreferredSize(new Dimension(50,23));
					}
					panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					panel.add(VSpinner);
				}
			}
		}
		setResizable(false);
		this.pack();
		this.setVisible(true);
	}

}
