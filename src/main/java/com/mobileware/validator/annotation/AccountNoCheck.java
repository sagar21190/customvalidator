package com.mobileware.validator.annotation;

import com.mobileware.validator.utility.PatternMatch;
import com.mwt.configuration.MWTMainConfigurationManager;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class AccountNoCheck extends AbstractAnnotationCheck<AccountNo> {
	private static final long serialVersionUID = 1L;
	private static final String ACCOUNTNO_LENGTH = MWTMainConfigurationManager.getInstance().getValue("accountlength");

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {
		boolean result = false;
		if (valueToValidate != null && valueToValidate.toString().trim().length() != 0) {

			String accountNo = valueToValidate.toString();
			accountNo = accountNo.trim().replaceAll("\\s", "");
			if (accountNo.matches(PatternMatch.NUMBERS_ONLY)) {
				if (accountNo.length() == Integer.parseInt(ACCOUNTNO_LENGTH)) {
					result = true;
				} else {
					result = false;
				}
			}

		}

		return result;
	}
}
