package org.sis.user.model;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class LoginUtil {

	public static String encryptPassword(String id, String pw) throws Exception{
        
        if(pw == null){
            return "";
        }
        
        byte[] hashValue = null;
        
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        
        md.reset();
        md.update(id.getBytes());
        
        hashValue = md.digest(pw.getBytes());
        
        return new String(Base64.encodeBase64(hashValue));
    }
	
	
}
