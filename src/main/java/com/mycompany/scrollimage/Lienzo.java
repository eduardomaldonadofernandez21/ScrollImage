package com.mycompany.scrollimage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Lienzo extends JPanel{
    
    private BufferedImage imagen;
    private Mat img = null;
    
    public Lienzo(){
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen != null){
            this.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
            g.drawImage(imagen,0,0,null);
        }
    }
    
    public void updateImage(File fichero){
        img = Imgcodecs.imread(fichero.getAbsolutePath());
        displayImage();
    }
    
    private void displayImage (){
        imagen = (BufferedImage)HighGui.toBufferedImage(img);
        repaint();
    }
    
    public boolean isImage(){
        return (imagen != null);
    }
    
    public Mat getImage(){
        return img;
    }
    
    public double[] getSizeImage(){
        return new double []{imagen.getWidth(), imagen.getHeight()};
    }
}
