package com.igor.homework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Employee {

	@Id
	@SequenceGenerator(name="seq", initialValue=100000, allocationSize=100000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name = "personal_id")
	private long  personalId;

	@Column(name = "name")
	private String name;

	@Column(name = "team")
	private String team;

	@Column(name = "team_lead")
	private String teamLead;

	public long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(long personalId) {
		this.personalId = personalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
	public Employee() {
	}
	
	public Employee(String name, String team, String teamLead) {
		this.name = name;
		this.team = team;
		this.teamLead = teamLead;
	}

		
	}
	

