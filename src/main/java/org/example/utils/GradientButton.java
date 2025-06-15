package org.example.utils;

import javax.swing.*;
import java.awt.*;

public class GradientButton extends JButton {

    public Color firstColor, secondColor;

    public GradientButton(String text, int height, int width, Color firstColor, Color secondColor){
        super(text);
        setMaximumSize(new Dimension(width, height));
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        setBorder(null);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //
        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint gradientPaint = new GradientPaint(0, 0, firstColor, 0, getHeight() + 20, secondColor);
        g2.setPaint(gradientPaint);
        //
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
