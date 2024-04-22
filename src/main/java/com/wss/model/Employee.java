package com.wss.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	@Id
	@Column(name = "employeeid")
	private long employeeid;
	@Column(name = "name")
	private String name;
	@Column(name = "department")
	private String department;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;

	
}
