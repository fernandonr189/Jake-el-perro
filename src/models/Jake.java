package models;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.*;

public class Jake extends JPanel {


    private final BufferedImage bufferedImage;
    private final int width, height;

    public Jake(BufferedImage _bufferedImage, int _width, int _height) {
        this.bufferedImage = _bufferedImage;
        this.width = _width;
        this.height = _height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = this.bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // TODO Actually draw jake

        drawBackgroundLandscape(graphics2D);

        g.drawImage(bufferedImage, 0, 0, this);
    }

    private void drawBackgroundLandscape(Graphics2D g2d) {

        // Colors
        Color nightBlue = new Color(0, 45, 101);
        Color sunsetOrange = new Color(255, 128, 0);
        Color grassGreen = new Color(19, 89, 0);

        // Background gradient
        GradientPaint gradient = new GradientPaint(0, 0, nightBlue, 0, getHeight() * (2), sunsetOrange);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Stars
        g2d.setColor(Color.WHITE);
        for(int i = 0; i < 50; i++) {
            int randX = (int) (Math.random() * (800));
            int randY = (int) (Math.random() * (250));
            g2d.drawLine(randX, randY, randX, randY);
        }

        // Hills
        GradientPaint gradient2 = new GradientPaint(0, -300, sunsetOrange, 0, 600, grassGreen);
        g2d.setPaint(gradient2);
        g2d.fillArc(0, 400, 800, 250, 0, 180);
        g2d.fillRect(0, 525, 800, 600);
    }
}
