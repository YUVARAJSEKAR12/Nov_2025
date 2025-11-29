package com.app.testone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.jasypt.util.text.AES256TextEncryptor;

public class ConfigReader {
	private static Properties props = new Properties();
    private static final String MASTER_KEY = "MBMMH6"; // 🔐 Use Env variable in real project

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = props.getProperty(key);
        if (value != null && value.startsWith("ENC(")) {
            AES256TextEncryptor encryptor = new AES256TextEncryptor();
            encryptor.setPassword(MASTER_KEY);

            String encryptedValue = value.substring(4, value.length() - 1);
            return encryptor.decrypt(encryptedValue);
        }
        return value;
    }
}
