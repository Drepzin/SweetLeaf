package org.example.utils;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class GradientBorder extends AbstractBorder {
    private final Color startColor;
    private final Color endColor;
    private final int thickness;

    public GradientBorder(Color startColor, Color endColor, int thickness) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gradiente horizontal
        GradientPaint gradient = new GradientPaint(0, 0, startColor, width, 0, endColor);

        g2.setPaint(gradient);
        g2.fillRect(x, y, width, thickness); // Top
        g2.fillRect(x, y, thickness, height); // Left
        g2.fillRect(x, y + height - thickness, width, thickness); // Bottom
        g2.fillRect(x + width - thickness, y, thickness, height); // Right
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(thickness, thickness, thickness, thickness);
        return insets;
    }
}
