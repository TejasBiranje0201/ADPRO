 package com.adpro.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String name;
	private Date createdon;

	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value = {"agencyId"},allowSetters = true)
	private Agency agency;
	@ManyToOne
	@JoinColumn(name="uroleId")
	@JsonIgnoreProperties(value= {"uroleId"},allowSetters = true)
	private Urole urole;


}
