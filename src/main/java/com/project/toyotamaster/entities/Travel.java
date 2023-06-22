package com.project.toyotamaster.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name ="travels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Travel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String travelDestination;
	private String purposeOfGoing;
	private String projectCode;
	private String travelCost;
	private String username;
	
	@Temporal(TemporalType.DATE)
	private Date travelStart;
	
	@Temporal(TemporalType.DATE)
	private Date  travelEnd;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user ;

}
