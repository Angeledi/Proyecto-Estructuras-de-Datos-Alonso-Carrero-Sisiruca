/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carrero_sisiruca_edd_secc2;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Angel Carrero Augusto Sisiruca
 */
public class Imagen extends javax.swing.JPanel {
    int cord_x, cord_y;
     /**
     * Metodo para mostrar la imagen decorativa
     * @param jPanel1 panel donde se coloca la imagen
     */
    public Imagen(JPanel jPanel1) {
        
        this.cord_x = jPanel1.getWidth();
        this.cord_y = jPanel1.getHeight();
        this.setSize(cord_x, cord_y);
    }

     /**
     * Override
     * @param grf Graficos
     */
    @Override
    public void paint(Graphics grf) {
        
        ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/imagen1.png"));
        grf.drawImage(Img.getImage(), 0, 0, cord_x, cord_y, null);
    }    

}

