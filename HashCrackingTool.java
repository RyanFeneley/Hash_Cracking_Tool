/**
 * Hash Cracking Tool - Dictionary Attack
 * 
 * Author: Ryan Feneley
 * Date: September  2024
 * 
 */

 import java.io.*;
 import java.security.MessageDigest;
 import java.security.NoSuchAlgorithmException;
 import java.util.Scanner;
 
 public class HashCrackingTool {
 
     // Function to hash a string using the specified algorithm
     public static String hashString(String algorithm, String input) {
         try {
             MessageDigest md = MessageDigest.getInstance(algorithm);
             byte[] hashBytes = md.digest(input.getBytes());
             StringBuilder sb = new StringBuilder();
             for (byte b : hashBytes) {
                 sb.append(String.format("%02x", b));
             }
             return sb.toString();
         } catch (NoSuchAlgorithmException e) {
             System.out.println("Error: Invalid hashing algorithm.");
             return null;
         }
     }
 
     // Function to perform the dictionary attack
     public static String dictionaryAttack(String targetHash, String algorithm, String dictionaryFile) {
         try (BufferedReader br = new BufferedReader(new FileReader(dictionaryFile))) {
             String candidatePassword;
             while ((candidatePassword = br.readLine()) != null) {
                 String hashedPassword = hashString(algorithm, candidatePassword);
 
                 // Compare the hashed version of the candidate with the target hash
                 if (hashedPassword != null && hashedPassword.equals(targetHash)) {
                     return candidatePassword;  // Match found
                 }
             }
         } catch (IOException e) {
             System.out.println("Error reading dictionary file: " + e.getMessage());
         }
         return null;
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.println("Enter the target hash:");
         String targetHash = scanner.nextLine();
 
         System.out.println("Enter the hashing algorithm (MD5, SHA-1, SHA-256):");
         String algorithm = scanner.nextLine().toUpperCase();
 
         System.out.println("Enter the path to the dictionary file:");
         String dictionaryFile = scanner.nextLine();
 
         System.out.println("Attempting to crack the hash...");
         String crackedPassword = dictionaryAttack(targetHash, algorithm, dictionaryFile);
 
         if (crackedPassword != null) {
             System.out.println("Success! The password is: " + crackedPassword);
         } else {
             System.out.println("Failed to crack the hash. Try with a larger dictionary or different hash algorithm.");
         }
 
         scanner.close();
     }
 }
 