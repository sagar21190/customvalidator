package com.mobileware.validator.annotation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class UpperCaseCheck extends AbstractAnnotationCheck<UpperCase> {

	private static final long serialVersionUID = 1L;

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {

		boolean result = false;
		if (valueToValidate != null && !valueToValidate.toString().isEmpty()) {
			String val = valueToValidate.toString().trim();
			if (val.equals(val.toUpperCase())) {
				result = true;
			}
		}
		return result;
	}

}
