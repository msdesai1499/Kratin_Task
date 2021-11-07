package com.jpa.test.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	private long bankId;
	private String bankName;
	private String bankAccNo;
	private String bankBranch;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankAccNo=" + bankAccNo + ", bankBranch="
				+ bankBranch + "]";
	}
	public Bank(long bankId, String bankName, String bankAccNo, String bankBranch) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankAccNo = bankAccNo;
		this.bankBranch = bankBranch;
	}
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	

}
