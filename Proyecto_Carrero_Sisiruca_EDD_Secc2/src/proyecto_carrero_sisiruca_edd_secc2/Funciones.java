/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carrero_sisiruca_edd_secc2;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sisir
 */
class Funciones {
    
  private static Component textTxt;
  public static File FileChooser() {
       
    File fichero = null;
       
    JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showSaveDialog(textTxt);
    if (seleccion == JFileChooser.APPROVE_OPTION)
    {
   fichero = fileChooser.getSelectedFile();}
    
    return fichero;
   
   }

  
    public static void LeerFichero(File archivo) {
            if (archivo == null) {
                JOptionPane.showMessageDialog(null, "Error! No se seleciono ningun archivo");
            } else {
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader (archivo);
                    br = new BufferedReader(fr);
// En esta parte se abre el fichero y se crea el BufferedReader con metodo readline()).
                }
                
         // Lectura del txt
                catch(Exception ex){
                    ex.printStackTrace();
                }
// En el finally cerramos el fichero.
                finally{
                    try{                    
                        if( null != fr ){   
                            fr.close();     
                        }                  
                    } catch (Exception ex2){ 
                        ex2.printStackTrace();}
                }
            }
        }
    
    
    public static Grafo leerTxt() {
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
            System.out.println("Hola1");
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
                    System.out.println("Hola2");
                }
                System.out.println("Hola5");
                String[] relaciones = grafo_split[1].split("\n");
                Grafo grafoTemp= new Grafo(usuarios);
                grafo = grafoTemp;
                System.out.println("Hola6");
                for (int i = 0; i < relaciones.length; i++) {
                    System.out.println("Holatal");
                    String[] dato_re = relaciones[i].split(", ");
                    grafo.newArco(grafo.returnUsuariobynum(Integer.parseInt(dato_re[0])), grafo.returnUsuariobynum(Integer.parseInt(dato_re[1])), Integer.parseInt(dato_re[2]));
                }
                System.out.println("Hola3");
            }
            br.close();
            JOptionPane.showMessageDialog(null, "lectura exitosa");
            System.out.println("Hola4");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error");

        }
        return grafo;
    }
    
    
    
    

}

