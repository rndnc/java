package jp.co.sss.test.advice;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.sss.test.exception.CartOperationException;
import jp.co.sss.test.exception.ReviewOperationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CartOperationException.class)
	public String handleCartOprationException(
			CartOperationException ex,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request
			) {

		String productId = request.getParameter("productId");
		
		redirectAttributes.addFlashAttribute("errorMessage","カート処理が失敗しました。もう一度お試しください。");
		
		return "redirect:/productDetail/" + productId;
	}
	
	@ExceptionHandler(ReviewOperationException.class)
	public String handleReviewOprationException(
			ReviewOperationException ex,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request
			) {

		redirectAttributes.addFlashAttribute("errorMessage","レビュー投稿処理が失敗しました。もう一度お試しください。");
		
		return "redirect:/review/" + ex.getProductId();
	}
	
}
