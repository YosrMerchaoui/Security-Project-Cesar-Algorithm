/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithmes;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yosr
 */
public class Main {
    
    
		public static void main(String[] args) throws FileNotFoundException, IOException { 
			Cesar message = new Cesar(17); 
                        
			System.out.println("Alphabet 1 = " + new String(message.texte_code)); 
			System.out.println("Alphabet 2 = " + new String(message.texte_clair));
                        
			String secret = "CAIUSSS JULIUS CESAR ";
                        String secret2= "caiusss julius cesar";
                        String secret3= "ssssssoussou is the best";
                        
                        
                        //int x = message.analyse_frequence(secret);
                        //System.out.println(message.alpha[0]);
                        
			secret = message.codage(secret); 
                        System.out.println(secret); 
                        
                        secret2 = message.codage(secret2); 
                        System.out.println(secret2); 
                        
                        secret3 = message.codage(secret3); 
                        System.out.println(secret3);
                        
                        int y = message.analyse_frequence(secret);
                        
			secret = message.decodage(secret); 
                        System.out.println(secret); 
                        
                        
                        // pass the path to the file as a parameter 
                        /*FileReader fr = new FileReader("E:\\test.txt"); 
                        int i; 
                        while ((i=fr.read()) != -1) 
                        System.out.print((char) i); 
                        System.out.println();*/
                        
                        /*System.out.println("Entrez le path du fichier");
                        Scanner scanner = new Scanner(System. in);
                        String inputString = scanner. nextLine();*/
                        
                        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                        dialog.setMode(FileDialog.LOAD);
                        dialog.setVisible(true);
                        String file = dialog.getFile(); 
                        String path = dialog.getDirectory() + dialog.getFile();
                        System.out.println("le path est "+path);
                        System.out.println(file + " chosen.");
                        
                        String mot="";
                        FileReader fr = new FileReader(path); 
                        int i; 
                        while ((i=fr.read()) != -1){ 
                        System.out.print((char) i); 
                        mot+= (char)i;
                        }
                        
                        System.out.println();
                        System.out.println("Entrez le nombre de decalage");
                        Scanner scanner = new Scanner(System. in);
                        int nombreDecalage = scanner. nextInt();
                        
                        Cesar message2 = new Cesar(nombreDecalage);
                        
                        System.out.println(mot);
                        
                        mot = message2.codage(mot); 
                        System.out.println(mot); 
                        
                        y = message.analyse_frequence(mot);
                        
                        dialog = new FileDialog((Frame)null, "Selectionnez le fichier où vous allez sauvegarder");
                        dialog.setMode(FileDialog.LOAD);
                        dialog.setVisible(true);
                        File[] fichier = dialog.getFiles(); 
                        
                        message2.sauvegarde_mot(fichier[0],mot);
                        
                        mot = message2.decodage(mot); 
                        System.out.println(mot); 
                        
                        System.exit(0);
                       
                        
		} 
    
}
