package com.easygame.sdk.common.util;

import org.springframework.validation.BindingResult;

public class ValidationUtils {
	
	public static void checkStringFieldNullOrEmpty(String field, String errorMessage, BindingResult bindingResult) {
		
		if (field == null && "".equals(field)) {
			
			bindingResult.rejectValue(field, null, errorMessage);
			
		}
		
	}
	
}
