package com.adpro.entity;

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
@Table(name="rolemodules")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RoleModule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="uroleId")
	@JsonIgnoreProperties(value = {"uroleId"}, allowSetters = true)
	private Urole urole;
	@ManyToOne
	@JoinColumn(name="moduleid")
	@JsonIgnoreProperties(value = {"moduleId"}, allowSetters = true)
	private Module module;
}
