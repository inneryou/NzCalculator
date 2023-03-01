package com.turedurenaru;

import java.awt.*;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class TriangleSquareWindowsCornerIcon implements Icon{

    private static final int WIDTH = 12;
    private static final int HEIGHT = 12;

    private static final Color SQUARE_COLOR_LEFT = new Color(184,180, 163);
    private static final Color SQUARE_COLOR_TOP_RIGHT = new Color(184,180, 161);
    private static final Color SQUARE_COLOR_BOTTOM_RIGHT = new Color(184,181, 161);

    private static final Color THREE_D_EFFECT_COLOR = new Color(255, 255, 255);

    private void draw3dSquare(Graphics g, int x, int y){
        Color oldColor = g.getColor();
        g.setColor(THREE_D_EFFECT_COLOR);
        g.fillRect(x,y,2,2);
        g.setColor(oldColor);
    }

    private void drawSquare(Graphics g, int x, int y){
        Color oldColor = g.getColor();
        g.setColor(SQUARE_COLOR_LEFT);
        g.drawLine(x,y, x,y+1);
        g.setColor(SQUARE_COLOR_TOP_RIGHT);
        g.drawLine(x+1,y, x+1,y);
        g.setColor(SQUARE_COLOR_BOTTOM_RIGHT);
        g.drawLine(x+1,y+1, x+1,y+1);
        g.setColor(oldColor);
    }
    @Override
    public int getIconHeight() {
        return WIDTH;
    }

    @Override
    public int getIconWidth() {
        return HEIGHT;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int firstRow = 0;
        int firstColumn = 0;
        int rowDiff = 4;
        int columnDiff = 4;

        int secondRow = firstRow + rowDiff;
        int secondColumn = firstColumn + columnDiff;
        int thirdRow = secondRow + rowDiff;
        int thirdColumn = secondColumn + columnDiff;

        // 一列目
        draw3dSquare(g, firstColumn + 1, thirdRow + 1);

        // 二列目
        draw3dSquare(g, secondColumn + 1, secondRow + 1);
        draw3dSquare(g, secondColumn + 1, thirdRow + 1);

        //三列目
        draw3dSquare(g, thirdColumn + 1, firstRow + 1);
        draw3dSquare(g, thirdColumn + 1, secondRow + 1);
        draw3dSquare(g, thirdColumn + 1, thirdRow + 1);

        //一列目
        drawSquare(g, firstColumn, thirdRow);

        // 二列目
        drawSquare(g, secondColumn, secondRow);
        drawSquare(g, secondColumn, thirdRow);

        //三列目
        drawSquare(g, thirdColumn, firstRow);
        drawSquare(g, thirdColumn, secondRow);
        drawSquare(g, thirdColumn, thirdRow);

    }
    
}
