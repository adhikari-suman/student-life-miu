package lab_20240419_w3d4.level_1.prog_3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menus extends JFrame implements ActionListener {

    public Menus() {
        setTitle("Menus");

        JMenuBar menuBar = new JMenuBar();

        // Add a menu
        JMenu myMenu = new JMenu("My Menu");

        JMenuItem menuItem1 = new JMenuItem("Menu Item 1");
        JMenuItem menuItem2 = new JMenuItem("Menu Item 2");
        JMenuItem menuItem3 = new JMenuItem("Menu Item 3");

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);

        myMenu.add(menuItem1);
        myMenu.add(menuItem2);
        myMenu.add(menuItem3);

        menuBar.add(myMenu);

        setJMenuBar(menuBar);

        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    // Implementing ActionListener interface method
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        System.out.println(menuItem.getText() + " clicked!");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


                    Menus frame = new Menus();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
