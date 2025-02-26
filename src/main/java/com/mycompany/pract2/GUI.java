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
import java.util.ArrayList;

public class GUI extends JFrame {

    JLabel label = new JLabel("List of heretics");
    JLabel information = new JLabel("");
    JButton button = new JButton("Create");
    Controller control;
    ArrayList<String> heretics;

    public GUI(Controller controller) {
        JPanel bestPnl = (JPanel)getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        float t = 35, m = 20;
        label.setFont(label.getFont().deriveFont(t));
        this.control = controller;

        add(button);
        add(label);
        add(information);

        GridLayout layout = new GridLayout(5, 1);
        setLayout(layout);

        button.addActionListener(new Event1());

        pack();
        setVisible(true);
    }

    private class Event1 implements ActionListener {
        final GUI main = GUI.this;

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame menu1 = new Popup(main);
            menu1.setVisible(true);
            menu1.pack();
            setVisible(false);
        }
    }

    public void create(String name, String crimes, String place, int id, int lv){
        this.heretics.add(this.control.create(name, crimes, place, id, lv));

    }

}
