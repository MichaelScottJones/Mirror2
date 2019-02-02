package com.michaelscottjones.mirror2.UIElements;

import com.michaelscottjones.mirror2.JSONUtils;

import javax.swing.*;
import java.awt.*;

public class Weather extends JPanel {

    private JLabel condition;
    private JLabel temp;

    public Weather() {
        this.condition = new JLabel();
        this.condition.setForeground(Color.WHITE);
        this.condition.setFont(new Font("sans-serif", Font.PLAIN, 75));
        this.temp = new JLabel();
        this.temp.setForeground(Color.WHITE);
        this.temp.setFont(new Font("sans-serif", Font.PLAIN, 75));
        this.setBackground(Color.BLUE);
        updateWeather();
        this.add(condition);
        this.add(temp);

        Dimension maxSize = new Dimension();
        maxSize.setSize(500, 200);
        this.setAlignmentX(0);
        this.setMaximumSize(maxSize);


    }

    public void updateWeather() {
        String[] weatherData = JSONUtils.getWeather();
        this.condition.setText(weatherData[0]);
        double t = Double.parseDouble(weatherData[1]);
        t = (t - 273.15) * (9/5) + 32;
        long T = Math.round(t);
        this.temp.setText(T + "°F");
    }
}
