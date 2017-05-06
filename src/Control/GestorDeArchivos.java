package Control;

import Modelo.Archivos;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by cesar on 3/05/17.
 */
public class GestorDeArchivos {

    Archivos archivos = new Archivos();
    public String GestorDeArchivos(String fileRout){


        String file = archivos.Archivos(fileRout);

        return file;
    }

    public String BuscaArchivo(String chosenFile){

        String text = archivos.AbrirArchivo(chosenFile);

        return text;
    }

    public String Evaluacion(String text, String evaluation){

        Scanner reading = null;
        String userName = "", fileName = "";
        try {
            reading = new Scanner(new File("/home/cesar/Documents/FCC/Primavera 2017/Ingenieria de Software/ActiveUser.txt"));
            while (reading.hasNextLine()) {
                Scanner word = new Scanner(reading.nextLine());
                while (word.hasNextLine()) {
                    userName = word.nextLine();
                }
            }
            reading.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"THIS MESSAGE SHOULD NEVER BE DISPLAYED","Error",JOptionPane.ERROR_MESSAGE);
        }

        try {
            reading = new Scanner(new File("/home/cesar/Documents/FCC/Primavera 2017/Ingenieria de Software/ActiveFile.txt"));
            while (reading.hasNextLine()) {
                Scanner word = new Scanner(reading.nextLine());
                while (word.hasNextLine()) {
                    fileName = word.nextLine();
                }
            }
            reading.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"THIS MESSAGE SHOULD NEVER BE DISPLAYED","Error",JOptionPane.ERROR_MESSAGE);
        }

        String rout = "/home/cesar/Documents/FCC/Primavera 2017/Ingenieria de Software/Proyecto Final/src/Textos Evaluados/";

        switch (evaluation){
            case "0":
                rout += userName+"/"+fileName+"-Juicio.txt";
                break;

            case "1":
                rout += userName+"/"+fileName+"-Apreciacion.txt";
                break;

            case "2":
                rout += userName+"/"+fileName+"-Afecto.txt";
                break;
        }
        archivos.GuardarEvaluacion(text, rout);

        return "";
    }
}
