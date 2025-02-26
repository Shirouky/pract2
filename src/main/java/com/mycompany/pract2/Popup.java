/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pract2;

/**
 *
 * @author luba_
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Popup  extends JFrame {
    NumberFormat principleFormat = NumberFormat.getNumberInstance();

    JLabel label = new JLabel("Create");
    JLabel name = new JLabel("Name: ");
    JLabel crimes = new JLabel("Crimes: ");
    JLabel place = new JLabel("Place of last apperance: ");
    JLabel id = new JLabel("ID: ");
    JLabel level = new JLabel("Level of threat: ");

    JTextField nameField = new JTextField("", 10);
    JTextField placeField = new JTextField("", 10);
    JTextField crimesField = new JTextField("", 10);
    JFormattedTextField idField = new JFormattedTextField(principleFormat);

    JRadioButton var1 = new JRadioButton("Low", true);
    JRadioButton var2 = new JRadioButton("Middle", false);
    JRadioButton var3 = new JRadioButton("High", false);
    JRadioButton var4 = new JRadioButton("Critical", false);

    JButton button = new JButton("Finish");
    GUI main;

    public Popup(GUI main) {
        this.main = main;
        add(label);
        add(name);
        add(nameField);
        add(crimes);
        add(crimesField);
        add(place);
        add(placeField);
        add(id);
        add(idField);
        add(level);


        ButtonGroup var = new ButtonGroup();
        var.add(var1);
        var.add(var2);
        var.add(var3);
        var.add(var4);
        add(var1);
        add(var2);
        add(var3);
        add(var4);
        add(button);

        JPanel bestPnl = (JPanel) getContentPane();
        bestPnl.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(700, 500);
        setVisible(true);
        setLayout(new GridLayout(6, 2));

        button.addActionListener(new Event());
    }

    private class Event implements ActionListener {
        final Popup menu = Popup.this;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = nameField.getText();
                String crimes = crimesField.getText();
                String place = placeField.getText();
                int id = ((Number) idField.getValue()).intValue();

                int lv = 0;
                if (var1.isSelected()) {
                    lv = 1;
                } else if (var2.isSelected()) {
                    lv = 2;
                } else if (var3.isSelected()) {
                    lv = 3;
                } else if (var4.isSelected()) {
                    lv = 4;
                }

                JOptionPane.showMessageDialog(Popup.this, "Новый пользователь создан");
                menu.main.setVisible(true);
                menu.main.create(name, crimes, place, id, lv);
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(Popup.this, "Нет числового параметра");
            }

        }
    }
}