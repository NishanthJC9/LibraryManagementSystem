package com.library.model;

public class Reader {
	private String readerName;
	private String email;
	private long mobileNumber;
	private String password;
	private String confirmPassword;
	public Reader(String readerName, String email, long mobileNumber, String password, String confirmPassword) {
		super();
		this.readerName = readerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Reader(String readerName, String email, long mobileNumber, String password) {
		super();
		this.readerName = readerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
