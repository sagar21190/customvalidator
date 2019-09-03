package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.ErrorCode.Constants;
import com.mobileware.validator.utility.PatternMatch;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class PPINCheck extends AbstractAnnotationCheck<PPin> {
	private static final long serialVersionUID = 1L;

	// @Override
	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {
		boolean result = true;
		if (valueToValidate != null && valueToValidate.toString().trim().length() != 0) {
			String pPIN = valueToValidate.toString();
			if (!pPIN.trim().matches(PatternMatch.PPIN_4DIGITFORMAT)) {
				this.setErrorCode(Constants.PPIN_4DIGITFORMAT_ERRORCODE);
				this.setMessage(Constants.PPIN_4DIGITFORMAT_ERRORMSG);
				return false;
			}
			if (!pPIN.trim().matches(PatternMatch.PPIN_CONSECUTIVE)) {
				this.setErrorCode(Constants.PPIN_CONSECUTIVE_ERRORCODE);
				this.setMessage(Constants.PPIN_CONSECUTIVE_ERRORMSG);
				return false;
			}
			if (checkConsecutive(pPIN)) {
				this.setErrorCode(Constants.PPIN_CONSECUTIVE_ERRORCODE);
				this.setMessage(Constants.PPIN_CONSECUTIVE_ERRORMSG);
				return false;
			}
			if (pPIN.trim().matches(PatternMatch.PPIN_SEQUENCE)) {
				this.setErrorCode(Constants.PPIN_SEQUENCE_ERRORCODE);
				this.setMessage(Constants.PPIN_SEQUENCE_ERRORMSG);
				return false;
			}
		} else {
			return false;
		}
		return result;

	}

	private boolean checkConsecutive(String pPIN) {
		for (int i = 0; i < pPIN.length(); i++) {
			if ((i != pPIN.length() - 1) && (pPIN.charAt(i) == pPIN.charAt(i + 1))) {
				this.setErrorCode(Constants.PPIN_CONSECUTIVE_ERRORCODE);
				this.setMessage(Constants.PPIN_CONSECUTIVE_ERRORMSG);
				return true;
			}
		}
		return false;

	}

}
