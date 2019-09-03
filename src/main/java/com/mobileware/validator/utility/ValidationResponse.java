package com.mobileware.validator.utility;

public class ValidationResponse {

	private String errorCode;
	private String errorMSG;

	public ValidationResponse() {

	}

	public ValidationResponse(String errorCode, String errorMSG) {
//		 super();
		this.errorCode = errorCode;
		this.errorMSG = errorMSG;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMSG() {
		return errorMSG;
	}

	public void setErrorMSG(String errorMSG) {
		this.errorMSG = errorMSG;
	}

	@Override
	public String toString() {
		return "ValidationResponse [errorCode=" + errorCode + ", errorMSG=" + errorMSG + "]";
	}

}
