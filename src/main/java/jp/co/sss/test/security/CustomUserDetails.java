package jp.co.sss.test.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.sss.test.entity.User;

public class CustomUserDetails implements UserDetails{
	private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // ← ここが照合される
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // ← ここでBCryptと照合される
    }
    
    public User getUser() {
        return user;
    }

    // 他のメソッドは基本true返す形でOK（今は簡易実装でも大丈夫）
    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
