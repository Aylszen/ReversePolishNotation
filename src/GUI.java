import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUI {
	static JTextField dataTextField;
	static JFrame jFrame;
	static JButton submitButton;
	static JLabel enteredDataLabel;
	static JLabel dataLabel;
	static JLabel currentStateLabel;
	static JLabel postfixLabel;
	static JTable dataTable;
	static JPanel firstPanel;
	static JPanel secondPanel;
	static JPanel thirdPanel;
	static int place;
	static boolean isRunning = false;
	static JLabel dataCorrect;

	public GUI() {
		jFrame = new JFrame("Reverse Polish Notation");
		enteredDataLabel = new JLabel("No Data entered");
		dataLabel = new JLabel("Data:");
		dataCorrect = new JLabel("-");
		dataTextField = new JTextField();
		submitButton = new JButton("Submit");
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		thirdPanel = new JPanel();
		dataTable = new JTable();
		postfixLabel = new JLabel("---");
		Font font = new Font("Serif", Font.PLAIN, 24);
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.PAGE_AXIS));
		firstPanel.add(dataTextField, BorderLayout.NORTH);
		dataTextField.setFont(font);
		secondPanel.setLayout(new GridLayout(1, 3));
		secondPanel.add(submitButton);
		secondPanel.add(dataLabel);
		dataLabel.setHorizontalAlignment(JLabel.CENTER);
		secondPanel.add(enteredDataLabel);
		enteredDataLabel.setFont(font);

		thirdPanel.setLayout(new GridLayout(1, 2));
		thirdPanel.add(dataCorrect);
		thirdPanel.add(postfixLabel);
		dataCorrect.setFont(font);
		postfixLabel.setFont(font);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReversePolishNotation.run();				
			}
		});

		jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		// add panel to frame
		jFrame.add(firstPanel);
		jFrame.add(secondPanel);
		jFrame.add(thirdPanel);
		// set the size of frame
		jFrame.setSize(600, 300);

		jFrame.show();
	}

}
