package com.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bank")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bank {
	
	@Column(name="id")
	@Id
	private Long bankId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="branch")
	private String branch;

	@OneToMany(mappedBy="bank",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ProbationaryOfficer> probationaryOfficer;

	public Bank(Long bankId, String bankName, String branch) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.branch = branch;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<ProbationaryOfficer> getProbationaryOfficer() {
		return probationaryOfficer;
	}

	public void setProbationaryOfficer(List<ProbationaryOfficer> probationaryOfficer) {
		this.probationaryOfficer = probationaryOfficer;
	}

	public Bank() {
		super();
	}
}
