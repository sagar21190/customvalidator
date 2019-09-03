package com.mobileware.validator.utility;

import com.mwt.configuration.MWTMainConfigurationManager;

public class PatternMatch {
	private PatternMatch() {
	}

	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static final String NUMBERS_ONLY = "^\\d*$";

	public static final String BLANK_SPACE = "\\s";

	// can take the range of dd/mm/yy
	public static final String DATE_FORMAT = MWTMainConfigurationManager.getInstance().getValue("date_format");
	// (0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)
	// ^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$

	// pincode has 6 digits
	public static final String PINCODE_FORMAT = "^[0-9]{3}([0-9]{3})?$?";

	// ifsc code shld be 11 digits (1st 4 alphbets 0 after this (6 any digits) and 7
	// digits).
	public static final String IFSC_FORMAT = "[A-Z|a-z]{4}[0][0-9]{6}$";

	// pancard is 10 digit alphanumeric characters 5 alphabets 4 numbers and last
	// digit is alphabet.
	public static final String PANCARD_FORMAT = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

	// passport 1 alphabet A-PR-W
	public static final String PASSPORT_FORMAT = "^[A-PR-WYa-pr-wy]{1}[1-9]{7}$";

	// aadhar card 12 digits in which the first one digit should not be 0 or 1
	public static final String AADHAR_FORMAT = "^[2-9]{1}[0-9]{11}$";

	public static final String BANK_CUSTOMER = MWTMainConfigurationManager.getInstance().getValue("bank_customer");

	public static final String PASSWORD_FORMAT = MWTMainConfigurationManager.getInstance().getValue("password_format");

	// public static final String PPIN_FORMAT = "^(?!(.)\\1{3})(?!19|20)\\d{4}$";

	public static final String PPIN_4DIGITFORMAT = "^\\d{4}$";

	public static final String PPIN_CONSECUTIVE = "^(?!(.)\\1{1})\\d{4}$";

	public static final String PPIN_SEQUENCE = "^(0123|1234|2345|3456|4567|5678|6789|7890|3210|4321|5432|6543|7654|8765|9876|0987|0000|1111|2222|3333|4444|5555|6666|7777|8888|9999)$";

}
