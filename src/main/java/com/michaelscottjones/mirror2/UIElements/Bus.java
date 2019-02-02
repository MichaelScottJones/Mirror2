package com.michaelscottjones.mirror2.UIElements;

import com.michaelscottjones.mirror2.JSONUtils;

import javax.swing.*;
import java.awt.*;

public class Bus extends JPanel {
    private JLabel time;
    private JLabel name;

    public Bus() {
        this.time = new JLabel();
        this.time.setForeground(Color.WHITE);
        this.time.setFont(new Font("sans-serif", Font.PLAIN, 75));
        this.name = new JLabel();
        this.name.setForeground(Color.WHITE);
        this.name.setFont(new Font("sans-serif", Font.PLAIN, 75));
        this.setBackground(Color.BLUE);
        updateWeather();
        this.add(time);
        this.add(name);

        Dimension maxSize = new Dimension();
        maxSize.setSize(500, 200);
        this.setAlignmentX(0);
        this.setMaximumSize(maxSize);


    }

    public void updateWeather() {
        String[] busData = JSONUtils.getBus();
        this.time.setText(busData[0]);
        this.name.setText(busData[1]);
    }
}
