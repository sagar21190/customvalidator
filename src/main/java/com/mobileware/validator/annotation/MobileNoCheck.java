package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.PatternMatch;
import com.mwt.configuration.MWTMainConfigurationManager;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class MobileNoCheck extends AbstractAnnotationCheck<MobileNo> {
	private static final long serialVersionUID = 1L;
	private static final Integer MOBNO_LENGTH1 = Integer
			.parseInt(MWTMainConfigurationManager.getInstance().getValue("mobNo_length1"));

	private static final Integer MOBNO_LENGTH2 = Integer
			.parseInt(MWTMainConfigurationManager.getInstance().getValue("mobNo_length2"));

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {
		boolean result = false;
		if (valueToValidate != null && !valueToValidate.toString().isEmpty()) {
			String mobileNo = valueToValidate.toString().trim();
			mobileNo = mobileNo.replaceAll("\\s", "");
			if (mobileNo.matches(PatternMatch.NUMBERS_ONLY) && isValidMobileNo(mobileNo)) {
				result = true;
			} else {
				this.setMessage("Kindly Enter Valid Mobile Number");
			}
		}
		return result;
	}

	private boolean isValidMobileNo(String mobileNo) {
		boolean isValidMobileNo = false;
		if ((mobileNo.length() == MOBNO_LENGTH1 || mobileNo.length() == MOBNO_LENGTH2)
				&& (mobileNo.matches("9{1}1{1}[6-7-8-9]{1}[0-9]{9}") || mobileNo.matches("[6-7-8-9]{1}[0-9]{9}"))) {
			isValidMobileNo = true;
		}
		return isValidMobileNo;
	}
}
