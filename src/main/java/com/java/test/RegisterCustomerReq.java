package com.java.test;

import com.mobileware.validator.annotation.BBPSMobileNo;

public class RegisterCustomerReq {

	// @MobileNo
	@BBPSMobileNo
	private String mobileNo;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "RegisterCustomerReq [mobileNo=" + mobileNo + "]";
	}

}
