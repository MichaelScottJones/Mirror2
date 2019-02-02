package com.michaelscottjones.mirror2.UIElements;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JPanel {

    private JLabel label;

    public Clock() {
        this.label = new JLabel();
        this.label.setForeground(Color.WHITE);
        this.label.setFont(new Font("sans-serif", Font.PLAIN, 75));
        this.setBackground(Color.BLUE);
        updateTime();
        this.add(label);

        Dimension maxSize = new Dimension();
        maxSize.setSize(500, 200);
        this.setAlignmentX(0);
        this.setMaximumSize(maxSize);


    }

    public void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
        this.label.setText(sdf.format(new Date()).toLowerCase());
    }
}
