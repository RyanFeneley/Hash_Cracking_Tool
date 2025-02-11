# Hash Cracking Tool

## Overview
The Hash Cracking Tool is a Java application designed to crack hashed passwords using a dictionary attack. It supports common hashing algorithms like MD5, SHA-1, and SHA-256, allowing users to attempt to recover original plaintext passwords from their hashed versions.

**Important:** This tool is strictly for educational purposes and should only be used on systems where you have explicit permission.

## Features
- Supports MD5, SHA-1, and SHA-256 hashing algorithms.
- Uses a dictionary file to attempt to find the original plaintext password.
- Can be extended to handle salted hashes.

## Requirements
- Java Development Kit (JDK) 8 or higher.

## Usage
1. Clone the repository or download the code.
2. Compile the Java program using the following command:
   \\\ash
   javac HashCrackingTool.java
   \\\
3. Run the program:
   \\\ash
   java HashCrackingTool
   \\\

4. When prompted, enter the target hash you want to crack.
5. Specify the hashing algorithm (MD5, SHA-1, or SHA-256).
6. Provide the path to the dictionary file containing potential passwords.

### Example Usage
- Start the Hash Cracking Tool by running the following commands:
   \\\ash
   javac HashCrackingTool.java
   java HashCrackingTool
   \\\

- Follow the prompts to input the target hash, select the algorithm, and specify the dictionary file.

## How it Works
- The tool reads potential passwords from a specified dictionary file and hashes each password using the selected algorithm.
- It compares the hashed versions of the candidate passwords against the target hash.
- If a match is found, it reports the original plaintext password.

**Disclaimer: This tool is for educational purposes only. Unauthorized use is illegal and unethical.**
