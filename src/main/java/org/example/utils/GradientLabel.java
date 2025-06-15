package org.example.utils;

import javax.swing.*;
import java.awt.*;

public class GradientLabel extends JLabel {

    private Color firstColor, secondColor;

    public GradientLabel(String font, String text, int size, Color firstColor, Color secondColor){
        super(text);
        setFont(new Font(font, Font.BOLD, size));
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //setting the graphics2d and antialiasing
        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint gradientPaint = new GradientPaint(0, 0, firstColor, 0, getHeight(), secondColor);
        g2.setPaint(gradientPaint);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //definition of area
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getHeight();
        //
        int x = (textWidth - getWidth())/ 2;
        int y = (textHeight + getHeight())/ 2 - fm.getDescent();
        //drawing the label with the gradient colors
        g2.drawString(getText(), x, y);
        g2.dispose();
    }
}
