package com.michaelscottjones.mirror2;

import com.michaelscottjones.mirror2.UIElements.Bus;
import com.michaelscottjones.mirror2.UIElements.Clock;
import com.michaelscottjones.mirror2.UIElements.Weather;

import javax.swing.*;
import java.awt.*;

public class SwingUI {

    private JFrame f;
    private Clock clock;
    private Weather weather;
    private Bus bus;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Clock clock = new Clock();
        Weather weather = new Weather();
        Bus bus = new Bus();

        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
        f.getContentPane().setBackground(Color.BLACK);

        f.add(clock);
        f.add(weather);
        f.add(bus);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // f.setUndecorated(true);
        f.setVisible(true);
    }

    public SwingUI() {
        this.f = new JFrame();
        this.clock = new Clock();
        this.weather = new Weather();
        this.bus = new Bus();

        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
        f.getContentPane().setBackground(Color.BLACK);

        f.add(clock);
        f.add(new Clock());

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // f.setUndecorated(true);
        f.setVisible(true);
    }


}
