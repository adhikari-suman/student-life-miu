package lesson6.exercise_2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This version of MyFrame supports a button listener but
 * does not support an error dialog. The listener is placed
 * outside the class. It also illustrates more creative use
 * of layout managers to create a more interesting arrangement
 * of components.
 *
 */
public class MyFrameLambda extends JFrame {
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel textPanel;
	private JTextField text;
	private JLabel label;
	private JButton button;
	private JButton button2;
	public MyFrameLambda() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		pack();
		centerFrameOnDesktop(this);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		defineTextPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(textPanel);
		
	}
//	private void defineMiddlePanel(){
//		middlePanel=new JPanel();
//		middlePanel.setLayout(new BorderLayout());
//		JPanel subpanel1 = new JPanel();
//		JPanel subpanel2 = new JPanel();
//		subpanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
//		subpanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
//		middlePanel.add(subpanel1, BorderLayout.NORTH);
//		middlePanel.add(subpanel2, BorderLayout.CENTER);
//		
//		button = new JButton("My Button");
//		button2 = new JButton("Second Button");
//		subpanel1.add(button);
//		subpanel2.add(button2);
//		
//	}
	
	
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton("My Button");
		button.addActionListener(new MyButtonListener());
		button2 = new JButton("Second Button");
		//button2.addActionListener(/*insert lambda expression here */);
		middlePanel.add(button);
		middlePanel.add(button2);
		
	}
	private void defineTextPanel() {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		text = new JTextField(10);
		label = new JLabel("My Text");
		label.setFont(makeSmallFont(label.getFont()));
		topText.add(text);
		bottomText.add(label);
		
		textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");		
		
		handleWindowClosing();
		//setSize(320,250);
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	private void handleWindowClosing() {
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                dispose();
				//other clean-up
                System.exit(0);
           }
        }); 				
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
				MyFrameLambda mf = new MyFrameLambda();
				mf.setVisible(true);
			}
		});
	}
	
	void showMessage(String message){
		JOptionPane.showMessageDialog(this,         									          
		          message,
		          "Error", 
		          JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}
	
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String textVal = text.getText();
			final String prompt = "Type a string";
			final String youWrote = "You wrote: ";
			if(textVal.equals("") || 
					textVal.equals(prompt) || 
					textVal.startsWith(youWrote)){
				
				text.setText(prompt);
			}
			else if(textVal.equalsIgnoreCase("error")){
				showMessage("An error has occurred!");
				text.setText(prompt);
			}
			else {
				text.setText(youWrote+"\""+textVal+"\".");
			}
		}
	}
	
	
	
	private static final long serialVersionUID = 3618976789175941431L;
}
	