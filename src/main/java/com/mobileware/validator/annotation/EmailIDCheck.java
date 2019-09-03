package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.PatternMatch;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class EmailIDCheck extends AbstractAnnotationCheck<EmailId> {
	private static final long serialVersionUID = 1L;

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {

		boolean result = false;
		if (valueToValidate != null) {
			String emailID = valueToValidate.toString().trim();
			if (emailID.matches(PatternMatch.EMAIL_PATTERN)) {
				result = true;
			}
		}
		return result;

	}
}
