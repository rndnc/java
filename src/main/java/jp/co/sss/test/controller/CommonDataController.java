package jp.co.sss.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.sss.test.entity.Category;
import jp.co.sss.test.repository.CategoryRepository;
import jp.co.sss.test.security.CustomUserDetails;

@ControllerAdvice
public class CommonDataController {

	@Autowired
	private CategoryRepository categoryRepository;

	//検索機能で使用するカテゴリー情報取得
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}

	//サイドバーの非表示(デフォルトでfalse)
	@ModelAttribute("showSidebar")
	public boolean getShowSidedbar() {
		return false;
	}
	
	@ModelAttribute("loginUserName")
	public String getLoginUserName() {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof CustomUserDetails customUser) {
	        return customUser.getUser().getUserName();
	    }
	    return null;
	}
}
