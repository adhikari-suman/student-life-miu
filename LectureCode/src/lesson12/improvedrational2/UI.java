package lesson12.improvedrational2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI extends JFrame {
	private Controller ctrl;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JTextField first, second, third, fourth, sum;
	public void setSum(String s) {
		sum.setText(s);
	}
	public UI() {
		ctrl = new Controller(this);
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		defineLowerPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		
		
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel title = new JLabel("Adding Fractions");
		Font large = makeLargeFont(title.getFont());
		title.setFont(large);
		topPanel.add(title);
		
	}
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		first = new JTextField(3);
		second = new JTextField(3);
		third = new JTextField(3);
		fourth = new JTextField(3);
		sum = new JTextField(5);
		JLabel over1 = new JLabel(" / ");
		JLabel over2 = new JLabel(" / ");
		JLabel plus = new JLabel(" + ");
		JLabel eq = new JLabel(" = ");
		middlePanel.add(first);
		middlePanel.add(over1);
		middlePanel.add(second);
		middlePanel.add(plus);
		middlePanel.add(third);
		middlePanel.add(over2);
		middlePanel.add(fourth);
		middlePanel.add(eq);
		middlePanel.add(sum);
	
	}
	
	private void defineLowerPanel() {
		JButton addbutn = new JButton("Add");
		JButton clearButn = new JButton("Clear");
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		lowerPanel.add(addbutn);lowerPanel.add(clearButn);
		clearButn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				first.setText("");
				second.setText("");
				third.setText("");
				fourth.setText("");
				sum.setText("");
			}
		});
		addbutn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					ctrl.performAddition(Integer.parseInt(first.getText()),
							Integer.parseInt(second.getText()),
							Integer.parseInt(third.getText()),
							Integer.parseInt(fourth.getText()));
					
				} catch(IllegalArgumentException e) {
					throw e;
				}
			}
		});
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Exception-Handling for Rational");	
		centerFrameOnDesktop(this);
		setSize(350,160); 
		setResizable(false);
	}
	public static Font makeLargeFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()+2));
    }

	
	public static void centerFrameOnDesktop(Component f) {
	        final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				UI ui = new UI();
				ui.setVisible(true);
			}
		});
	}
	
	
	
	public void showMessage(String message){
		JOptionPane.showMessageDialog(this,         									          
		          message,
		          "Error", 
		          JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}
	
	private static final long serialVersionUID = 3618976789175941431L;
}
	