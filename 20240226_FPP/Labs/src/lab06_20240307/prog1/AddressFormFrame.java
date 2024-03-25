package lab06_20240307.prog1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AddressFormFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField streetTextField;
	private JLabel lblStreet;
	private JTextField cityTextField;
	private JLabel lblCity;
	private JTextField stateTextField;
	private JLabel lblState;
	private JTextField zipTextField;
	private JLabel lblZip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressFormFrame frame = new AddressFormFrame();
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
	public AddressFormFrame() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Address Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(86, 42, 45, 13);
		contentPane.add(lblNewLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(86, 65, 130, 19);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		streetTextField = new JTextField();
		streetTextField.setColumns(10);
		streetTextField.setBounds(226, 65, 130, 19);
		contentPane.add(streetTextField);
		
		lblStreet = new JLabel("Street");
		lblStreet.setBounds(226, 42, 45, 13);
		contentPane.add(lblStreet);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(366, 65, 130, 19);
		contentPane.add(cityTextField);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(366, 42, 45, 13);
		contentPane.add(lblCity);
		
		stateTextField = new JTextField();
		stateTextField.setColumns(10);
		stateTextField.setBounds(141, 117, 130, 19);
		contentPane.add(stateTextField);
		
		lblState = new JLabel("State");
		lblState.setBounds(141, 94, 45, 13);
		contentPane.add(lblState);
		
		zipTextField = new JTextField();
		zipTextField.setColumns(10);
		zipTextField.setBounds(281, 117, 130, 19);
		contentPane.add(zipTextField);
		
		lblZip = new JLabel("ZIP");
		lblZip.setBounds(281, 94, 45, 13);
		contentPane.add(lblZip);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String street = streetTextField.getText();
				String city = cityTextField.getText();
				String zip = zipTextField.getText();
				String state = stateTextField.getText();
				
				StringBuilder sb= new StringBuilder();
				
				sb.append(String.format("%s\n", name));
				sb.append(String.format("%s\n", street));
				sb.append(String.format("%s, %s %s\n", city, state,zip));
				
				System.out.print(sb);
				
			}
		});
		btnNewButton.setBounds(256, 163, 100, 31);
		contentPane.add(btnNewButton);
	}
}
