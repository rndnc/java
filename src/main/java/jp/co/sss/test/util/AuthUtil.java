package jp.co.sss.test.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import jp.co.sss.test.entity.User;
import jp.co.sss.test.security.CustomUserDetails;

public class AuthUtil {
	
    public static User getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof CustomUserDetails customUser) {
            return customUser.getUser();
        }
        return null;
    }
	
	public static Integer getLoginUserId() {
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof CustomUserDetails customUser) {
	        return customUser.getUser().getUserId();
	    }
	    return null;
	}
}
