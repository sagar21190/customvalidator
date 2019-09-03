package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.PatternMatch;
import com.mwt.configuration.MWTMainConfigurationManager;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class BBPSMobileNoCheck extends AbstractAnnotationCheck<MobileNo> {
	private static final long serialVersionUID = 1L;
	private static final Integer BBPSMOBNO_MINLENGTH = Integer
			.parseInt(MWTMainConfigurationManager.getInstance().getValue("bbpsmobNo_minlength"));
	private static final Integer BBPSMOBNO_MAXLENGTH = Integer
			.parseInt(MWTMainConfigurationManager.getInstance().getValue("bbpsmobNo_maxlength"));

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
		if (mobileNo.matches("^[0-9]{" + BBPSMOBNO_MINLENGTH + "," + BBPSMOBNO_MAXLENGTH + "}$")) {
			isValidMobileNo = true;
		}
		return isValidMobileNo;
	}
}
