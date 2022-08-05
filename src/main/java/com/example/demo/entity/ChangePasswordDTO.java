package com.example.demo.entity;

public class ChangePasswordDTO {
  
	private int userID;
	private String oldPaaword;
	private String newPassword;
	private String confirmPassword;
	
	
	public String getOldPaaword() {
		return oldPaaword;
	}
	public void setOldPaaword(String oldPaaword) {
		this.oldPaaword = oldPaaword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	
	
}
