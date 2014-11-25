package com.upcera.ddx.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.upcera.ddx.common.security.CtyptoUtil;

@SuppressWarnings("deprecation")
@Component("PasswordEncode")
public class PasswordEncode implements PasswordEncoder{
	private CtyptoUtil cty;
	@Autowired 
    public void setCty(@Qualifier("CtyptoUtil") CtyptoUtil cty) {  
        this.cty = cty;  
    }
	@SuppressWarnings("static-access")
	@Override
	public String encodePassword(String rawPass, Object salt) {
		// TODO Auto-generated method stub
        try {
			return cty.EncryptString(rawPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; 
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		// TODO Auto-generated method stub
		if (encPass.equals(encodePassword(rawPass, salt))) {  
            return true;  
        }  
        return false; 
	}
}
