package com.tahauddin.syed.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SPECIALIZATION_TBL")
public class Specialization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "spec_id")
	private Long specId;
	
	@Column(name = "spec_code")
	private String specCode;
	
	@Column(name = "spec_name")
	private String specName;

	@Column(name = "spec_note")
	private String specNote;
}
