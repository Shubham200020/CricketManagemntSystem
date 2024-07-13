package com.example.demo.POJO.location;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "State")
public class State {
	@Id
	@Column(name="state_id",length = 5)
	private String stateid;
	@OneToMany(targetEntity = City.class,cascade =  CascadeType.ALL)
	@JoinColumn(name = "state_id")
	private List<City>city;
	@Column(name = "state_name",unique=true)

	private String statename;
	
	public State() {
		super();
	}
	
	
	public State(String stateid, String statename) {
		super();
		this.stateid = stateid;
		this.statename = statename;
	}


	public State(String stateid, List<City> city, String statename) {
		super();
		this.stateid = stateid;
		this.city = city;
		this.statename = statename;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city2) {
		this.city = city2;
	}
	@Override
	public String toString() {
		return "State [stateid=" + stateid + ", city=" + city + "]";
	}
	
	
	
}
