/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleencryption;

/**
 *
 * @author Kyle's PC
 */
import javax.swing.*;

public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initialize variables
        String inPhrase, inRot, inOption, enPhrase;
        int rot, x, choice;
        //initialize phrase input window
        inPhrase = JOptionPane.showInputDialog("This program will encrypt or decrypt a phrase using the\nsimple encryption method of rotating the letters");
        //newPhrase = "";

        //initialize rotation amount input window and parse to int
        inRot = JOptionPane.showInputDialog("Enter the rotation amount (1-25)");
        rot = Integer.parseInt(inRot);

        //initialize option window
        inOption = JOptionPane.showInputDialog("1 - Encryption\n2 - Decryption");
        choice = Integer.parseInt(inOption);

        enPhrase = "";

        //check for uppercase letters in sentences
        x = inPhrase.length();
        int[] up = new int[x];
        for (int i = 0; i < x; i++) {
            up[i] = inPhrase.charAt(i);
        }

        //set input to lower case
        inPhrase = inPhrase.toLowerCase();
        System.out.println(choice);
        if (choice == 1) {
            //compares character place to an array of the characters forming the input string
            for (char place : inPhrase.toCharArray()) {
                enPhrase = enPhrase + Character.toString((char) (((place - 'a' + rot) % 26) + 'a'));
            }

            //puts uppercase letters back in their original place
            for (int i = 0; i < x; i++) {
                if (up[i] >= 65 && up[i] <= 90) {
                    char c = enPhrase.charAt(i);
                    up[i] = (up[i] + rot);
                    while (up[i] >= 90) {
                        up[i] = 65 + (((up[i]) - 90) - 1);
                    }
                    while (up[i] < 65) {
                        up[i] = 90 - (1 + (65 + (up[i])));
                    }
                    enPhrase = enPhrase.replace(c, (char) (up[i]));
                }
            }
        } else {
        }
        if (choice == 2) {
            for (char place : inPhrase.toCharArray()) {
                enPhrase = enPhrase + Character.toString((char) (place - rot));
            }

            //puts uppercase letters back in their original place
            for (int i = 0; i < x; i++) {
                if (up[i] >= 65 && up[i] <= 90) {
                    char c = enPhrase.charAt(i);
                    up[i] = (up[i] - rot);
                    while (up[i] < 65) {
                        up[i] = 90 - (1 + (65 + (up[i])));
                    }
                    while (up[i] > 90) {
                        up[i] = 65 + (((up[i]) - 90) - 1);
                    }                  
                    enPhrase = enPhrase.replace(c, (char) (up[i]));
                }
            }
        }
        JOptionPane.showMessageDialog(null, enPhrase);
    }
}
