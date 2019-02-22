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
        int rot, choice;
        //initialize phrase input window
        inPhrase = JOptionPane.showInputDialog("This program will encrypt or decrypt a phrase using the\nsimple encryption method of rotating the letters");
        //newPhrase = "";

        //initialize rotation amount input window and parse to int
        inRot = JOptionPane.showInputDialog("Enter the rotation amount (1-25)");
        rot = Integer.parseInt(inRot);

        //initialize option window
        inOption = JOptionPane.showInputDialog("1 - Encryption\n2 - Decryption");
        choice = Integer.parseInt(inOption);

        //set ending phrase to empty so that it can be filled with charactes 
        enPhrase = "";

        //if user chooses to encrypt the input
                if (choice == 1) {
            //compares character place to an array of the characters forming the input string
            for (char place : inPhrase.toCharArray()) {
                //if char is a capital letter, set encrypted letter to uppercase character within range
                if ((int) place >= 65 && (int) place <= 90) {
                    enPhrase = enPhrase + Character.toString((char) (((place - 'A' + rot) % 26) + 'A')).toUpperCase();
                    //if char is not uppercase, set encrypted letter to lowercase character within range
                } else {
                    enPhrase = enPhrase + Character.toString((char) (((place - 'a' + rot) % 26) + 'a'));
                }
            }       
          //if user chooses to decrypt the input
        } else if (choice == 2) {
            //compares character place to an array of the characters forming the input string
            for (char place : inPhrase.toCharArray()) {
                //if char is a capital letter, set decrypted letter to uppercase character within range
                if ((int) place >= 65 && (int) place <= 90) {
                    enPhrase = enPhrase + Character.toString((char) (((place - rot + 'A') % 26) + 'A')).toUpperCase();
                  //if char is out of range, set decrypted letter to correct lowercase character within range
                } else if ((int)place - rot < 97) {
                    enPhrase = enPhrase + Character.toString((char) ('z' - ('a' - (place - rot) - 1)));
                  //if char is lowercase and in range, set decrypted letter
                } else {
                    enPhrase = enPhrase + Character.toString((char) (place - rot));
                }
            }
        }
        //display ending phrase
        JOptionPane.showMessageDialog(null, enPhrase);
    }
}
