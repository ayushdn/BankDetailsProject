package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProbationaryOfficer {
	
	public ProbationaryOfficer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Column(name="id")
	@Id
	private Long id;
	
	@Column(name="name")
	private String name;
	
	public ProbationaryOfficer(Long id, String name, int salary, Bank bank) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "ProbationaryOfficer [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Column(name="salary")
	private int salary;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="did",referencedColumnName="id")
	private Bank bank;

}
