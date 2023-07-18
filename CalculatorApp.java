import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class CalculatorApp{
	private JFrame frame;
	private JPanel panel;
	private GridBagConstraints gbc;
	private JTextField textField;

	CalculatorApp(){
		createGui();
	}
	private void createGui() {
		textField = new JTextField();
		textField.setEditable(false);//cannot take an input
		textField.setHorizontalAlignment(SwingConstants.RIGHT);//make contents of the textField button shifted to the right

		gbc = new GridBagConstraints();

		frame = new JFrame("Calculator App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		panel = new JPanel(new GridBagLayout());

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		MyActionListener myActionListener = new MyActionListener(textField);

		addButton(panel, "AC", 0, 0, myActionListener);
		addButton(panel, "+/-", 1, 0, myActionListener);
		addButton(panel, "%", 2, 0, myActionListener);
		addButton(panel, "/", 3, 0, myActionListener);
		addButton(panel, "7", 0, 1, myActionListener);
		addButton(panel, "8", 1, 1, myActionListener);
		addButton(panel, "9", 2, 1, myActionListener);
		addButton(panel, "X", 3, 1, myActionListener);
		addButton(panel, "4", 0, 2, myActionListener);
		addButton(panel, "5", 1, 2, myActionListener);
		addButton(panel, "6", 2, 2, myActionListener);
		addButton(panel, "-", 3, 2, myActionListener);
		addButton(panel, "1", 0, 3, myActionListener);
		addButton(panel, "2", 1, 3, myActionListener);
		addButton(panel, "3", 2, 3, myActionListener);
		addButton(panel, "+", 3, 3, myActionListener);
		addButton(panel, "0", 0, 4, 2, myActionListener);

		gbc.gridwidth = 1; /*since we were spanning O button to take up to columns
		and by doing so we set the gridWidth to 2, we need to reset it back to 1 so
		that the other buttons are of the same size */

		addButton(panel, ".", 2, 4, myActionListener);
		addButton(panel, "=", 3, 4, myActionListener);

		frame.add(textField, BorderLayout.NORTH);
		frame.add(panel);
		frame.setVisible(true);

	}
	public void addButton(JPanel panel, String text, int gridx, int gridy, ActionListener listener) {
		gbc.gridx = gridx; //position horizontal
		gbc.gridy = gridy; //position vertical

		JButton button = new JButton(text);
		button.addActionListener(listener);
		panel.add(button, gbc);

	}
	//overloaded constructor for the O button to take up 2 columns
	public void addButton(JPanel panel, String text, int gridx, int gridy, int gridwidth, ActionListener listener) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;

		JButton button = new JButton(text);
		button.addActionListener(listener);
		gbc.gridwidth = gridwidth;
		panel.add(button, gbc);
	}
}
