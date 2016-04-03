package com.nimishs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

/**
 * Created by NMSH on 03-04-2016.
 */

public class Main {

    JFrame mainFrame=new JFrame("Changing Properties");
    JLabel propertyLabel;
    final JMenuBar menuBar = new JMenuBar();
    JMenuItem properties;

    public static void main(String[] args) {
	// write your code here

        new Main().prepareGUI();

    }

    private Color getColor(String value)
    {
        Color color;

        try {
            Field field = Class.forName("java.awt.Color").getField(value);
            color = (Color)field.get(null);
        } catch (Exception ex) {
            color = null; // Not defined

        }

        return color;
    }
    private void prepareGUI(){

        mainFrame.setSize(400,400);
        mainFrame.setLayout(new BorderLayout());

        JTextField textField = new JTextField(20);
        JTextField bgColorField = new JTextField(20);
        JTextField fontColorField = new JTextField(20);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Text:"));
        myPanel.add(textField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Background Color:"));
        myPanel.add(bgColorField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Font Color:"));
        myPanel.add(fontColorField);


        propertyLabel=new JLabel("Changing Properties",JLabel.CENTER);
        propertyLabel.setOpaque(true);
        mainFrame.add(propertyLabel,BorderLayout.CENTER);

        JMenu menu=new JMenu("Configure");
        properties=new JMenuItem("Properties");
        JMenuItem option2=new JMenuItem("Option2");
        JMenuItem option3=new JMenuItem("Option3");

        menu.add(properties);
        menu.add(option2);
        menu.add(option3);
        menuBar.add(menu);
        menuBar.setVisible(false);
        mainFrame.setJMenuBar(menuBar);

        propertyLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON3)
                {
                    menuBar.setVisible(true);
                    properties.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           int result  = JOptionPane.showConfirmDialog(null,myPanel,"Enter the values",JOptionPane.OK_CANCEL_OPTION);

                            if (result == JOptionPane.OK_OPTION) {

                                propertyLabel.setText(textField.getText());
                                propertyLabel.setBackground(getColor(bgColorField.getText()));
                                propertyLabel.setForeground(getColor(fontColorField.getText()));

                                mainFrame.repaint();
                            }

                        }
                    });
                }

                else
                    menuBar.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);

    }
}
