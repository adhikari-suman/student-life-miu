package lesson8.listbindingjavafx;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Illustrates a single JList with add and remove item
 * support. When items are added or removed, a
 * ListDataListener notices the change and adjusts
 * the underlying data list accordingly.
 * 
 * Note that even with a ListDataListener, if the background list
 * is modified, the UI list is not updated automatically (see
 * the Modify List button)
 */
public class ListsListenener extends JFrame {
	private List<String> defaultList = new ArrayList<>();
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel listCopyPanel;
	private JList<String> listCopy;
	private JList<String> mainList;
	private JScrollPane mainScroll;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JLabel label;
	private JButton removeSelectedButton, addItemButton, addBgroundButton;
	private JTextField addField;
	private JTextField bgroundField;
	public ListsListenener() {
		initializeWindow();
		initializeDefaultList();
		initializeModel(defaultList);
		mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);	
		getContentPane().add(mainPanel);
	}
	private void initializeDefaultList() {
		defaultList.add("Red");
		defaultList.add("Blue");
		defaultList.add("Yellow");
	}
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new BorderLayout());
		mainList = createJList();
		mainList.setFixedCellWidth(70);
		mainScroll = new JScrollPane(mainList);
//		mainScroll.setPreferredSize(
//			new Dimension(mainScroll.getWidth() + 1, mainScroll.getHeight()));
		JPanel jListPanel = new JPanel();
		jListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jListPanel.add(mainScroll);
		
		//remove item components
		JPanel removeItemPanel = new JPanel();
		removeItemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		removeSelectedButton = new JButton("Remove Selected");
		removeItemPanel.add(removeSelectedButton);
		
		
		//add item components
		JPanel largerAddPanel = new JPanel();
		
		//add to UI list
		JPanel addItemPanel = new JPanel();
		addItemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addItemButton = new JButton("Add Item   ");
		addField = new JTextField(10);
		addItemPanel.add(addItemButton);
		addItemPanel.add(addField);
		
		//add to background list
		JPanel addBgroundPanel = new JPanel();
		addBgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addBgroundButton = new JButton("Modify List");
		bgroundField = new JTextField(10);
		addBgroundPanel.add(addBgroundButton);
		addBgroundPanel.add(bgroundField);
		
		largerAddPanel.setLayout(new BorderLayout());
		largerAddPanel.add(addItemPanel, BorderLayout.NORTH);
		largerAddPanel.add(addBgroundPanel, BorderLayout.CENTER);
		
		//arrange in middlePanel
		middlePanel.add(jListPanel, BorderLayout.NORTH);
		middlePanel.add(removeItemPanel, BorderLayout.CENTER);
		middlePanel.add(largerAddPanel, BorderLayout.SOUTH);
		
		removeSelectedButton.addActionListener(new RemoveListener());
		addItemButton.addActionListener(new AddItemListener());
		addBgroundButton.addActionListener(new ModifyListListener());
	}
	
	private void initializeModel(List<String> vals) {
		for(String s : vals){
			listModel.addElement(s);
		}
		listModel.addListDataListener(new MyListDataListener());
	}
	private JList<String> createJList() {
		JList<String> ret = new JList<String>(listModel);
		ret.setVisibleRowCount(4);
		
		return ret;
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");	
		centerFrameOnDesktop(this);
		//setSize(320,160); 
		setResizable(true);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
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
				ListsListenener mf = new ListsListenener();
				mf.pack();
				mf.setVisible(true);
			}
		});
	}
	
	class AddItemListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String newVal = addField.getText();
			listModel.addElement(newVal);
			addField.setText("");
			System.out.println(defaultList);
		}
	}
	
	class ModifyListListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String newVal = bgroundField.getText();
			defaultList.add(newVal);
			System.out.println(defaultList);
		}
	}
	
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			List<String> selected = mainList.getSelectedValuesList();
			for(String s: selected) {
				listModel.removeElement(s);
				//keep default list in synch
				//defaultList.remove(s);
			}
			System.out.println(defaultList);
			
			
			/* use if list is made single-select
			String s = mainList.getSelectedValue();
			listModel.removeElement(s);
			
			//keep underlying list in synch
			defaultList.remove(s);
			
			System.out.println(defaultList);*/
		}
	}
	
	//////// illustrates how data model can be used for multiple presentations ////
	private void defineTopPanel() {
		topPanel = new JPanel();
		//will be used in Lists2.java
	}
	
	class MyListDataListener implements ListDataListener {

		@Override
		public void intervalAdded(ListDataEvent e) {
			int index0 = e.getIndex0();
			int index1 = e.getIndex1();
			for(int i = index0; i <= index1; ++i) {
				defaultList.add(listModel.get(i));
			}
			
		}

		@Override
		public void intervalRemoved(ListDataEvent e) {
			int index0 = e.getIndex0();
			int index1 = e.getIndex1();
			for(int i = index0; i <= index1; ++i) {
				defaultList.remove(i);
			}
			
		}

		@Override
		public void contentsChanged(ListDataEvent e) {
			//do nothing
			
		}
		
	}
	
	
	private static final long serialVersionUID = 3618976789175941431L;
}
