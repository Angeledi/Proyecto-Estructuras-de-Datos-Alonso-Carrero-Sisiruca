/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_alonso_carrero_sisiruca_edd_secc2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

/**
 *
 * @author acarr
 */
public class Pruebas {
    
    public Grafo leer_txt() {
        Lista usuarios = new Lista();
        Grafo grafo = new Grafo(usuarios);
        String line;
        String grafo_txt = "";
        JFileChooser archivo = new JFileChooser();
        archivo.showOpenDialog(null);
        File abre = archivo.getSelectedFile();
        try {
            FileReader fr = new FileReader(abre);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    grafo_txt += line + "\n";
                }
            }
            if (!"".equals(grafo_txt)) {
                String[] grafo_split = grafo_txt.split("Relaciones\n");

                String[] string_users = grafo_split[0].split("\n");
                for (int i = 0; i < string_users.length; i++) {
                    if (i != 0) {

                        String[] Usuario = string_users[i].split(", ");
                        int u_number = Integer.parseInt(Usuario[0]);
                        String nombreUsuario = Usuario[1];
                        usuarios.InsertFinal(nombreUsuario, u_number );
                    }
                }
                String[] relaciones = grafo_split[1].split("\n");
                grafo = new Grafo(usuarios);
                for (int i = 0; i < relaciones.length; i++) {
                    String[] dato_re = relaciones[i].split(", ");
                    grafo.newArco(grafo.returnUsuariobynum(Integer.parseInt(dato_re[0])), grafo.returnUsuariobynum(Integer.parseInt(dato_re[1])), Integer.parseInt(dato_re[2]));
                }
            }
            br.close();
            JOptionPane.showMessageDialog(null, "lectura exitosa");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en lectura de archivo");

        }
        return grafo;
    }
    
}
