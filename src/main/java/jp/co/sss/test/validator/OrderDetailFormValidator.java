
package jp.co.sss.test.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.sss.test.form.orderDetailForm;

@Component
public class OrderDetailFormValidator {

	public List<String> addressValidate(orderDetailForm form){
		List<String> errors = new ArrayList<>();
		
		String selectedRadio = form.getAddress();
		
		if("radio1".equals(selectedRadio)) {
			if(isEmpty(form.getUserAddress()) && isEmpty(form.getUserApartment())) {
				errors.add("住所を入力してください(受け取り場所)");	
			}
		} else if("radio2".equals(selectedRadio)) {
			if(isEmpty(form.getNewAddress2()) && isEmpty(form.getNewApartment2())) {
				errors.add("住所を入力してください(受け取り場所)");
			}
		} else if("radio3".equals(selectedRadio)) {
			if(isEmpty(form.getNewAddress3()) && isEmpty(form.getNewApartment3())) {
				errors.add("住所を入力してください(受け取り場所)");
			}
		}
		
		return errors;
	}
	
	private boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}
}
