package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.PatternMatch;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class PasswordCheck extends AbstractAnnotationCheck<Passport> {
	private static final long serialVersionUID = 1L;

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {
		boolean result = false;
		if (valueToValidate != null && !valueToValidate.toString().isEmpty()) {
			String password = valueToValidate.toString().trim();
			if (password.matches(PatternMatch.PASSWORD_FORMAT)) {
				result = true;
			}
		}
		return result;
	}
}