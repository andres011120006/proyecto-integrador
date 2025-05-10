/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utiles;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AplicarPhoto {
     public static void pintar(JLabel lbl, String ruta) {
        ImageIcon imagen = new ImageIcon(AplicarPhoto.class.getResource(ruta));
        ImageIcon icono = new ImageIcon(
            imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH)
        );
        lbl.setIcon(icono);
    }
}