package com.app.enc;

import java.io.FileInputStream;
import java.util.Properties;

import org.jasypt.util.text.BasicTextEncryptor;

public class ConfigLoader {
	 private Properties props;

	    public ConfigLoader(String propFilePath) throws Exception {
	        props = new Properties();
	        try (FileInputStream fis = new FileInputStream(propFilePath)) {
	            props.load(fis);
	        }
	    }

	    public String getDecryptedPassword() {
	        String master = System.getenv("ENCRYPTION_PASSWORD");
	        if (master == null) throw new RuntimeException("ENCRYPTION_PASSWORD not set");
	        BasicTextEncryptor encryptor = new BasicTextEncryptor();
	        encryptor.setPassword(master);

	        String stored = props.getProperty("password");
	        // If you used ENC(...) convention, strip it:
	        if (stored != null && stored.startsWith("ENC(") && stored.endsWith(")")) {
	            stored = stored.substring(4, stored.length() - 1);
	        }

	        return encryptor.decrypt(stored);
	    }

	    public String getUsername() { return props.getProperty("username"); }
}
