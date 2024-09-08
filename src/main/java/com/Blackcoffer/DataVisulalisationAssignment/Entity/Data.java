package com.Blackcoffer.DataVisulalisationAssignment.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.Blackcoffer.DataVisulalisationAssignment.Constants.Region;
import com.Blackcoffer.DataVisulalisationAssignment.Constants.Sectors;
import com.Blackcoffer.DataVisulalisationAssignment.Constants.Pestle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 1024)
	private String title;
	private String end_year;
	private String citylng;
	private String citylat;
	private String intensity;
	private String sector;
	private String topics;
	@Column(length = 1024)
	private String insight;
	private String swot;
	private String url;
	private String region;
	private String start_year;
	private String impact;
	private String published;
	private String city;
	private String Country;
	private String relevance;
	private String Pestle;
	private String source;
	private String likelihood;
	
	
	
	
	
	

}
