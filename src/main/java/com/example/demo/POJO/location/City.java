package com.example.demo.POJO.location;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CITY")
public class City {
	@Id
	
	@Column(name="city_id",length = 5)
	private String cityid;
	
	
	@Column(name="City_name",unique = true)
	private String cotyname;

	public String getCotyname() {
		return cotyname;
	}

	public City(String cityid, String cotyname) {
		super();
		this.cityid = cityid;
		this.cotyname = cotyname;
	}

	

	public void setCotyname(String cotyname) {
		this.cotyname = cotyname;
	}

	

	public City() {
		super();
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	

	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", state=" + "]";
	}
	
	
}
