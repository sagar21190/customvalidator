package com.java.test;

public class Test {

	public static void main(String agrs[]) {
		System.out.println("hi");
		// RegisterCustomerReq a = new RegisterCustomerReq();
		// a.setMobileNo("98222014");
		String mob = "91475869239147586923";
		int a = 6;
		// System.out.println(Validate.checkValidObject(a));
		// System.out.println(mob.matches("9{1}1{1}[6-7-8-9]{1}[0-9]{5}"));
		System.out.println((mob.matches("^[0-9]{" + a + ",20}$")));

	}

}
