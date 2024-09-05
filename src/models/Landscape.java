package models;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.*;

public class Landscape extends JPanel {


    private final BufferedImage bufferedImage;
    private final int width, height;

    public Landscape(BufferedImage _bufferedImage, int _width, int _height) {
        this.bufferedImage = _bufferedImage;
        this.width = _width;
        this.height = _height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = this.bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        graphics2D.setColor(new Color(135, 206, 235)); // Sky blue
        graphics2D.fillRect(0, 0, this.width, this.height);

        drawHills(graphics2D);

        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillOval(this.width - 150, 50, 100, 100);

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(100, 50, 150, 80);
        graphics2D.fillOval(200, 70, 130, 60);
        graphics2D.fillOval(250, 40, 170, 90);
        graphics2D.fillOval(400, 80, 180, 70);
        graphics2D.fillOval(450, 50, 150, 80);

        drawSmallHouse(graphics2D);

        g.drawImage(bufferedImage, 0, 0, this);
    }

    private void drawHills(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(34, 139, 34)); // Green color for the hills
        drawSingleHill(graphics2D,-100, this.height - 200, this.width / 2, 400);
        drawSingleHill(graphics2D, this.width / 2 - 200, this.height - 150, this.width / 2, 300);
        drawSingleHill(graphics2D, this.width - 400, this.height - 250, this.width / 2, 500);
    }

    private void drawSingleHill(Graphics2D graphics2D, int x, int y, int width, int height) {
        graphics2D.setColor(new Color(34, 139, 34));
        graphics2D.fillOval(x, y, width, height);
        BasicStroke dotted = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0);

        int maxX = x + width;
        int maxY = y + height;
        int h = ((maxX - x) / 2) + x;
        int k = ((maxY - y) / 2) + y;
        graphics2D.setColor(Color.GREEN);
        graphics2D.setStroke(dotted);
        for(int dx = x; dx <= maxX; dx = dx + 10) {
            int positiveDy = (int) sqrt((1 - sqrt(pow(dx - h, 2)/(pow(((double) width / 2), 2)))) * pow(((double) height / 2), 2));
            int negativeDy = -positiveDy;
            graphics2D.drawLine(dx, negativeDy + k, dx - 10, positiveDy + k);
        }
    }

    private void drawSmallHouse(Graphics2D g2d) {
        int houseBaseX = this.width / 2 - 100;
        int houseBaseY = this.height - 300;
        int houseWidth = 200;
        int houseHeight = 150;

        g2d.setColor(new Color(178, 34, 34));
        g2d.fillRect(houseBaseX, houseBaseY, houseWidth, houseHeight);

        g2d.setColor(new Color(139, 69, 19));
        g2d.fillArc(houseBaseX - 10, houseBaseY - 50, houseWidth + 20, 100, 0, 180);

        g2d.setColor(new Color(160, 82, 45));
        g2d.fillRect(houseBaseX + houseWidth / 2 - 25, houseBaseY + houseHeight - 70, 50, 70);

        g2d.setColor(new Color(173, 216, 230));
        g2d.fillRect(houseBaseX + 20, houseBaseY + 30, 40, 40);
        g2d.fillRect(houseBaseX + houseWidth - 60, houseBaseY + 30, 40, 40);
    }
}
