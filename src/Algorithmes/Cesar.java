package Algorithmes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class Cesar { 
		public static final char[] alpha = 
			{'A','B','C','D','E','F','G','H','I','J','K','L','M',
			'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
		protected char[] texte_code = new char[26]; 
		protected char[] texte_clair = new char[26]; 
		
		public Cesar(Integer decalage) { 
		for (int i=0; i < 26; i++) texte_code[i] = alpha[(i + decalage) % 26]; 
		for (int i=0; i < 26; i++)
                    
                {   //System.out.println(texte_code[i]-'A');
                   // System.out.println(- 'A');
                    texte_clair[texte_code[i] - 'A'] = alpha[i]; 
                }
                
               }
                
		public String codage(String secret) { 
                        secret = secret.toUpperCase();
			char[] message = secret.toCharArray(); 
			for (int i=0; i < message.length; i++) 
				if (Character.isUpperCase(message[i])) 
					message[i] = texte_code[message[i] - 'A']; 
				return new String(message); 
		} 
		
		public String decodage(String secret) { 
                        secret = secret.toUpperCase();
			char[] message = secret.toCharArray(); 
			for (int i=0; i < message.length; i++) 
				if (Character.isUpperCase(message[i])) 
					message[i] = texte_clair[message[i] - 'A']; 
			return new String(message); 
		} 
                
                
                public int analyse_frequence(String fichier){
                    fichier = fichier.toUpperCase();
                    char[] texte = fichier.toCharArray();
                    int x;
                    Hashtable<Character, Integer> apparence = new Hashtable<Character, Integer>();
   
                    //on a initialisé l'appartion de chaque caractères avec des 0
                    for(int i=0; i<26;i++){
                    apparence.put(alpha[i],0);
                    }
                    
                    //System.out.println(apparence.get('A'));
                    
                    //on a comptabilisé pour chaque caractère le nombre de fois où il apparait
                    for (int i=0; i< texte.length;i++){
                    if (Character.isUpperCase(texte[i])){
                    x= apparence.get(texte[i]);
                     //System.out.println(x);
                    x++;
                    apparence.put(texte[i], x);
                    }
                    }
                    
                    //içi on va déterminer le caractère le plus utilisé
                    int max = apparence.get(alpha[0]);
                    char position = 'A';
                    
                    for (int i=0; i< 26;i++){
                    if (apparence.get(alpha[i])> max) {
                        max= apparence.get(alpha[i]);
                        position = alpha[i];
                    }
                    }
                    
                    //System.out.println(max);
                    //System.out.println(position);
                    
                    //on a supposé que la lettre E est la plus utilisé pour deduire le decalage
                    
                    int decalage ;
                    
                    if( position > 'S') decalage = position - 'S';
                    else decalage = 26 - ('S' - position);
                    
                    //System.out.println(-position);
                    System.out.println("le decalage est de "+ decalage +" caractères");
                  
                    return decalage;   
                }
                
                public void sauvegarde_mot(File fichier,String texte) throws FileNotFoundException, IOException{
        
                    try (FileOutputStream outputStream = new FileOutputStream(fichier)) {
                    byte[] strToBytes = texte.getBytes();
                    outputStream.write(strToBytes);
                    }
                }
              
                
	} 