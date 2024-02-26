package lesson6.employeephase2;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class UserIO extends JFrame  {
	
	
	//////////////constants
	private final String MAIN_LABEL = "User Input/Output Tool";
	private final String USER_INPUT = "User Input";
	private final String OUTPUT = "Output";
	private final String SUBMIT = "Submit";
	private final String CLEAR = "Clear Screen";
	
	//text areas
	private JTextArea upperText;
	private JTextArea lowerText;
	private String inputString;
	private String outputString;
	
	//JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel middleSubpanel;
	private JPanel lowerSubpanel;	

	private Main p = null;
	public UserIO(Main p) {
		this.p = p;
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
		//pack();
			
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setSize(GuiControl.SCREEN_WIDTH,GuiControl.SCREEN_HEIGHT);
		GuiControl.centerFrameOnDesktop(this);
		
	}
	
	private void defineMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(GuiControl.FILLER_COLOR);
		mainPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		defineUpperPanel();
		defineMiddlePanel();
		defineLowerPanel();
		mainPanel.add(upperSubpanel,BorderLayout.NORTH);
		mainPanel.add(middleSubpanel,BorderLayout.CENTER);
		mainPanel.add(lowerSubpanel,BorderLayout.SOUTH);
			
	}
		
	private void defineUpperPanel() {
		upperSubpanel = new JPanel();
		upperSubpanel.setBackground(GuiControl.FILLER_COLOR);
		upperSubpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upperSubpanel.add(mainLabel);		
	}
	private void defineMiddlePanel() {
		middleSubpanel = new JPanel();
		middleSubpanel.setLayout(new BorderLayout());
		middleSubpanel.setBackground(GuiControl.FILLER_COLOR);	
		middleSubpanel.setBorder(GuiControl.createBlueTitledBorder(USER_INPUT,middleSubpanel.getFont()));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//define textPanel
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		textPanel.setBackground(GuiControl.FILLER_COLOR);
		textPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		upperText = new JTextArea(8,54);
		textPanel.add(upperText);
		middleSubpanel.add(textPanel,BorderLayout.NORTH);
		
		//define button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(GuiControl.FILLER_COLOR);
		JButton submitButn = new JButton(SUBMIT);
		submitButn.addActionListener(new SubmitListener());
		buttonPanel.add(submitButn);
		middleSubpanel.add(buttonPanel,BorderLayout.SOUTH);
		
	}
	private void defineLowerPanel() {
		lowerSubpanel = new JPanel();
		lowerSubpanel.setLayout(new BorderLayout());
		lowerSubpanel.setBackground(GuiControl.FILLER_COLOR);	
		lowerSubpanel.setBorder(GuiControl.createBlueTitledBorder(OUTPUT,lowerSubpanel.getFont()));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//define textPanel
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		textPanel.setBackground(GuiControl.OUTPUT_SCREEN);
		textPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		lowerText = new JTextArea(8,54);
		JScrollPane scroll = new JScrollPane(lowerText);
		lowerText.setBackground(GuiControl.OUTPUT_SCREEN);
		lowerText.setEditable(false);
		textPanel.add(scroll);
		lowerSubpanel.add(textPanel,BorderLayout.NORTH);
		
		//define button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(GuiControl.FILLER_COLOR);
		JButton clearButn = new JButton(CLEAR);
		clearButn.addActionListener(new ClearListener());
		buttonPanel.add(clearButn);
		lowerSubpanel.add(buttonPanel,BorderLayout.SOUTH);        
				
	}
	void setOutputValue(){
		lowerText.setText(outputString);
	}
	public void setOutputString(String s){
		outputString = s;
	}

	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			inputString = upperText.getText();
			System.out.println("Got input: "+inputString);
			if(inputString.charAt(0)== 'y' || inputString.charAt(0)== 'Y'){
				outputString = p.getAllAccounts();
				setOutputValue();
			}
			else {
				outputString = "Thank you, goodbye.";
				setOutputValue();
			}
		    			
		}
	}
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
		    lowerText.setText("");	
		    System.out.println("Clearing output text area.");
		}
	}	
	
	public static void main(String[] args) {
			
		UserIO userIo = new UserIO(null);
		userIo.setVisible(true);
	}
	private static final long serialVersionUID = 3978706216115320117L;
}
