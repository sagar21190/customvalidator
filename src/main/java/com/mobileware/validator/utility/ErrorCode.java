package com.mobileware.validator.utility;

import com.mwt.configuration.MWTMainConfigurationManager;

public enum ErrorCode {

	TOKEN("TOKEN0001", "TOKEN_MISSING"), IP("IP0001", "IP_MISSING"), AUTHENTICATION("Auth0001",
			"AUTHENTICATION_FAILURE"), SUCCESS("S0001", "success"), FAILURE("A0001", "failure"), INVALID_REQUEST(
					"INR0001", "Invalid Input"), RECORD_NOTFOUND("RNF0001", "Record Not Found"), RECORE_EXISTING(
							"REX0001", "Record Already Existing"), RECORE_NOTEXISTING("RNE0001",
									"Record Does Not Existing"), MOBILE_INCORRECT("1",
											"Mobile Number is not correct"), PASSWORD_NOTMATCH("PNM001",
													"new password and confirm password doesn't match"), UPDATATION_SUCCESS(
															"", "Updated Successfully"), UPDATATION_FAILURE("",
																	"Not Updated Successfully"), PASSWORD_SAME("PNM001",
																			"new password and old password are same"), EMAIL(
																					"2",
																					"Email is not correct"), PERMISSION(
																							"2",
																							"No Permission "), AUTH_KEY(
																									"AUTHKEY0001",
																									"AUTHENTICATION KEY ABSENT "), EXCEPTION(
																											"EXCP0001",
																											"EXCEPTION OCCURED "), VALIDATION(
																													"VAL0001",
																													"VALIDATION FAILED ");

	private String code;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

	ErrorCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static class Constants {
		public static final String MOBILENO_INCORRECT_RANGE = "Mob_001";
		public static final String MOBILENO_NOTNULL = "Mob_002";
		public static final String MOBILENO_PATTERN_INCORRECT = "Mob_003";

		public static final String EMAIL_NOT_NULL = "Email_001";
		public static final String EMAIL__PATTERN_INCORRECT = "Email_002";

		public static final String INCORRECT_PASSWORD = "PWD_001";
		public static final String PASSWORD_PATTERN_INCORRECT = "PWD_002";
		public static final String PASSWORD_NOTNULL = "PWD_003";

		public static final String UPPERCASE = "UC001";
		public static final String BLANK_SPACE = "space_001";
		public static final String DATEOFBIRTH_INCORRECTPATTERN = "DOB_001";
		public static final String DATEOFBIRTH_NOTNULL = "DOB_002";

		public static final String PPIN_4DIGITFORMAT_ERRORCODE = MWTMainConfigurationManager.getInstance()
				.getValue("ppin.4digitformat.errorcode");
		public static final String PPIN_4DIGITFORMAT_ERRORMSG = MWTMainConfigurationManager.getInstance()
				.getValue("ppin.4digitformat.errormsg");

		public static final String PPIN_CONSECUTIVE_ERRORCODE = MWTMainConfigurationManager.getInstance()
				.getValue("ppin.consecutive.errorcode");
		public static final String PPIN_CONSECUTIVE_ERRORMSG = MWTMainConfigurationManager.getInstance()
				.getValue("ppin.consecutive.errormsg");

		public static final String PPIN_SEQUENCE_ERRORCODE = MWTMainConfigurationManager.getInstance()
				.getValue("ppin.sequence.errorcode");
		public static final String PPIN_SEQUENCE_ERRORMSG = MWTMainConfigurationManager.getInstance()
				.getValue("ppin.sequence.errormsg");

		private String code;
		private String msg;

		public String getMsg() {
			return msg;
		}

		public String getCode() {
			return code;
		}

		Constants(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}
	}
}
