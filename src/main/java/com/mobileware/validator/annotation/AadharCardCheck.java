package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.PatternMatch;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class AadharCardCheck extends AbstractAnnotationCheck<AadharCard> {
	private static final long serialVersionUID = 1L;

	// @Override
	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {

		boolean result = false;

		if (valueToValidate != null && valueToValidate.toString().trim().length() != 0) {
			String aadhar = valueToValidate.toString();
			if (aadhar.trim().matches(PatternMatch.AADHAR_FORMAT)) {
				result = true;
			}
		}
		return result;

	}
}
