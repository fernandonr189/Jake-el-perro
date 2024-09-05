package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static java.lang.Math.*;

public class Jake extends JPanel {


    private final BufferedImage bufferedImage;
    private final BufferedImage jakeTheDog;
    private final BufferedImage brickTexture;
    private final int width, height;

    private final Color nightBlue = new Color(0, 45, 101);
    private final Color sunsetOrange = new Color(255, 128, 0);
    private final Color grassGreen = new Color(19, 89, 0);
    private final Color brickOrange = new Color(120, 0, 0, 255);
    private final Color doorBrown = new Color(139, 69, 19);

    public Jake(BufferedImage _bufferedImage, int _width, int _height) {
        this.bufferedImage = _bufferedImage;
        this.width = _width;
        this.height = _height;
        this.brickTexture = createBrickTexture();
        this.jakeTheDog = createJakeImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = this.bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawBackgroundLandscape(graphics2D);
        drawBackgroundHouse(graphics2D);
        graphics2D.drawImage(jakeTheDog, 250, 230, this);
        g.drawImage(bufferedImage, 0, 0, this);
    }

    private void drawBackgroundHouse(Graphics2D g2d) {Rectangle houseRect = new Rectangle(250, 250, 300, 200);

        // Brick texture
        TexturePaint brickPaint = new TexturePaint(brickTexture, new Rectangle(0, 0, brickTexture.getWidth(), brickTexture.getHeight()));
        g2d.setPaint(brickPaint);
        g2d.fillRect(houseRect.x, houseRect.y, houseRect.width, houseRect.height);

        // Roof
        g2d.setColor(Color.DARK_GRAY);
        Polygon roof = new Polygon();
        roof.addPoint(230, 250);
        roof.addPoint(400, 150);
        roof.addPoint(570, 250);
        g2d.fillPolygon(roof);

        // Door
        g2d.setColor(doorBrown);
        g2d.fillRect(370, 350, 60, 100);

        // Windows
        g2d.setColor(Color.WHITE);
        g2d.fillRect(280, 280, 50, 50);
        g2d.fillRect(470, 280, 50, 50);
    }

    private void drawBackgroundLandscape(Graphics2D g2d) {

        // Background gradient
        GradientPaint gradient = new GradientPaint(0, 0, nightBlue, 0, getHeight() * (2), sunsetOrange);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Stars
        g2d.setColor(Color.WHITE);
        for(int i = 0; i < 50; i++) {
            int randX = (int) (random() * (800));
            int randY = (int) (random() * (250));
            g2d.drawLine(randX, randY, randX, randY);
        }

        // Hills
        GradientPaint gradient2 = new GradientPaint(0, -300, sunsetOrange, 0, 600, grassGreen);
        g2d.setPaint(gradient2);
        g2d.fillArc(0, 400, 800, 250, 0, 180);
        g2d.fillRect(0, 525, 800, 600);
    }

    private BufferedImage createBrickTexture() {
        BufferedImage brickImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = brickImage.createGraphics();

        // Fill background with brick color
        g2d.setColor(brickOrange);
        g2d.fillRect(0, 0, 50, 50);

        // Draw mortar lines
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(0, 24, 50, 24);
        g2d.drawLine(49, 25, 49, 50);
        g2d.drawLine(0, 49, 50, 49);
        g2d.drawLine(24, 0, 24, 24);
        g2d.dispose();
        return brickImage;
    }

    private BufferedImage createJakeImage() {
        BufferedImage jakeImage = null;
        try {
            jakeImage = ImageIO.read(new File("src/images/jake.png"));
        } catch (IOException e) {
            System.out.println("Could not find image");
        }
        return jakeImage;
    }

}
