package com.mobileware.validator.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

public final class Validate {
	private Validate() {
	}

	private static final Logger log = Logger.getLogger(Validate.class);

	public static ValidationResponse checkValidObject(Object object) {
		ValidationResponse vResponse = null;
		Validator validator = new Validator();
		List<net.sf.oval.ConstraintViolation> violations = validator.validate(object);

		if (!violations.isEmpty()) {
			try {
				net.sf.oval.ConstraintViolation constraintViolation = violations.get(0);
				String msg = constraintViolation.getMessage().replace(object.getClass().getName(), "");
				vResponse = new ValidationResponse(constraintViolation.getErrorCode(), msg);
			} catch (Exception e) {
				log.error("Validate_customValidationMethod(): ", e);
				vResponse = new ValidationResponse(ErrorCode.EXCEPTION.getCode(), ErrorCode.EXCEPTION.getMsg());
			}
		}
		return vResponse;
	}

	public List<ValidationResponse> validateObject(Object pObj) {
		List<ValidationResponse> lErrorList = new ArrayList<ValidationResponse>();

		try {
			net.sf.oval.Validator validator = new net.sf.oval.Validator();
			List<ConstraintViolation> lViolations = validator.validate(pObj);
			for (ConstraintViolation constraintViolation : lViolations) {
				ValidationResponse response = new ValidationResponse();
				response.setErrorCode(constraintViolation.getErrorCode());
				response.setErrorMSG(constraintViolation.getMessage());
				lErrorList.add(response);
			}
		} catch (Exception e) {
			log.error("Validate_validateObject(): ", e);
		}
		return lErrorList;
	}

}