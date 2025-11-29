package com.app.testone;

import org.jasypt.util.text.AES256TextEncryptor;

import org.jasypt.util.text.AES256TextEncryptor;

public class TestOne {
	
	public static void main(String[] args) {
        // Create an encryptor
        AES256TextEncryptor encryptor = new AES256TextEncryptor();

        // Provide a master password (encryption key)
        encryptor.setPassword("MyStrongMasterKey");

        // Encrypt your text (e.g., DB password, API key)
        String plainText = "MBMMH6";
        String encrypted = encryptor.encrypt(plainText);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt back
        String decrypted = encryptor.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

}
