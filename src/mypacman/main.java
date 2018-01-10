/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.AffineTransformOp;
import javax.swing.Timer;
import mypacman.objects.pacman;

/**
 *
 * @author bayasys
 */
public class main extends Frame implements ActionListener {

    RenderingHints rh;
    Dimension size;
    double w;
    double h;
    Timer timer;
    int x1 = 0, x2 = 100, y1 = 50, y2 = 100;
    pacman pm;

    public main() {
        super("PacMan");
        setSize(400, 300);
        setVisible(true);
        addKeyListener(new TAdapter());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        this.rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        this.rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        size = getSize();
        w = size.getWidth();
        h = size.getHeight();
        pm = new pacman(x2, y2);
        pm.setHeight(30);
        pm.setWidth(30);
        timer = new Timer(10, this);
        timer.start();

    }

    public static void main(String args[]) {
        new main();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
//        pm = new pacman(x1, y1);

        if (pm != null) {
            g2d.drawImage(pm.getImage(), pm.getX(), pm.getY(), pm.getWidth(), pm.getHeight(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pm.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

//        @Override
//        public void keyReleased(KeyEvent e) {
//            System.out.println("PRESSED");
//            pm.keyReleased(e);
//        }
        @Override
        public void keyPressed(KeyEvent e) {
            pm.keyPressed(e);
        }
    }

}
