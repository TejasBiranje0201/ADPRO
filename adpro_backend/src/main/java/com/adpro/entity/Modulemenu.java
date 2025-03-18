package com.adpro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
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
@Table(name="ModuleMenus")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Modulemenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="moduleid")
	@JsonIgnoreProperties(value = {"moduleId"}, allowSetters = true)
	private Module module;
	
	@ManyToOne
	@JoinColumn(name="menuId")
	@JsonIgnoreProperties(value = {"menuId"}, allowSetters = true)
	private Menu menu;
	
	
	

}
