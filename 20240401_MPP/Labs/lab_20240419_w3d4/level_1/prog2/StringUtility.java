package lab_20240419_w3d4.level_1.prog2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StringUtility extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputTextField;
	private JTextField outputTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringUtility frame = new StringUtility();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StringUtility() {
		setTitle("String Utility");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton reverseLettersBtn = new JButton("Reverse Letters");
		reverseLettersBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		reverseLettersBtn.addActionListener(new ActionListener() {
			// Reverse letter and display
			public void actionPerformed(ActionEvent e) {
				String inputText = inputTextField.getText();

				if (inputText == null || inputText.length() == 0) {
					outputTextField.setText("");
				} else { // reverse here

					StringBuilder sb = new StringBuilder();

					for (int i = inputText.length() - 1; i >= 0; i--) {
						sb.append(inputText.charAt(i));
					}

					outputTextField.setText(sb.toString());
				}
			}
		});
		reverseLettersBtn.setBounds(10, 66, 164, 46);
		contentPane.add(reverseLettersBtn);

		JButton removeDuplicatesBtn = new JButton("Remove Duplicates");
		removeDuplicatesBtn.addActionListener(new ActionListener() {
			// Remove duplicates
			public void actionPerformed(ActionEvent e) {
				String inputText = inputTextField.getText();

				if (inputText == null || inputText.length() == 0) {
					outputTextField.setText("");
				} else { // reverse here

					StringBuilder sb = new StringBuilder();

					for (int i = 0; i < inputText.length(); i++) {
						
						// if sb has no item index == -1
						// append if item has -1 index else do nothing
						if (sb.indexOf(String.valueOf(inputText.charAt(i))) == -1) {
							sb.append(inputText.charAt(i));
						}

					}

					outputTextField.setText(sb.toString());
				}
			}
		});
		removeDuplicatesBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		removeDuplicatesBtn.setBounds(10, 122, 164, 46);
		contentPane.add(removeDuplicatesBtn);

		JButton countLettersBtn = new JButton("Count Letters");
		countLettersBtn.addActionListener(new ActionListener() {
			// print length of string on outputTextField
			public void actionPerformed(ActionEvent e) {
				String inputText = inputTextField.getText();

				outputTextField.setText(String.valueOf(inputText.length()));
			}
		});
		countLettersBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		countLettersBtn.setBounds(10, 10, 164, 46);
		contentPane.add(countLettersBtn);

		JPanel panel = new JPanel();
		panel.setBounds(277, 43, 200, 104);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setBounds(2, 0, 94, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		inputTextField = new JTextField();
		inputTextField.setBounds(0, 23, 200, 25);
		panel.add(inputTextField);
		inputTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputTextField.setColumns(10);

		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(2, 56, 94, 13);
		panel.add(lblOutput);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 12));

		outputTextField = new JTextField();
		outputTextField.setBounds(0, 79, 200, 25);
		panel.add(outputTextField);
		outputTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		outputTextField.setColumns(10);
	}
}
