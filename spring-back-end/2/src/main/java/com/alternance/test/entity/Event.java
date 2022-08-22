package com.alternance.test.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Event {
	@Id
	@GeneratedValue
	private Long id ;
	
	@Enumerated(EnumType.STRING)
	private Type type ;
	
	private Date date ;
	private String titre ;
	private String description ;
	private ArrayList<String> photos ;
	
	@ManyToOne
	@JsonIgnore
	private User user;
}