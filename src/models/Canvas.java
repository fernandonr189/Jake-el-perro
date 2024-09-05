package models;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JFrame {

    public Canvas(int width, int height) {
        BufferedImage backgroundBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setTitle("Paisaje");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new Landscape(backgroundBuffer, width, height));
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}