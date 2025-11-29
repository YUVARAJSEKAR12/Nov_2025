package com.app.enc;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptPassword {
	public static void main(String[] args) {
        // Provide a master secret (do NOT hardcode in repo — use env var when running)
        String master = System.getenv("ENCRYPTION_PASSWORD"); 
        if (master == null) { System.err.println("Set ENCRYPTION_PASSWORD env var"); 
        System.exit(1); 
        }

        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(master);

        String plain = "MBMMH6";
        String encrypted = encryptor.encrypt(plain);
        System.out.println("Encrypted value: " + encrypted);
    }
}
