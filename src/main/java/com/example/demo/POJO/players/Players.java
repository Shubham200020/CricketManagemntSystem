package com.example.demo.POJO.players;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import com.example.demo.POJO.Score.ScoreBating;
import com.example.demo.POJO.location.City;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Players {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "player_id")
	private String playerid;
	@Column(name = "player_name",length = 50)
	private String name;
	@Column(name="email_id",length = 50 ,unique = true)
	private String email;
	@Column(name = "phone_number",length = 10,unique = true)
	private String phonenumber;
	@Column(name = "password",length = 16)
	private String password;
	@ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City address;
	@Column(name = "gender")
	private gender gen;
	@Column(name = "side")
	private side sd;
	@Column(name = "Role")
	private Role role;
	@Column(name = "date_Of_birth")
	private Date dob;

	public Players() {
		super();
	}


	public Players(String playerid, String name, String email, String phonenumber, String password, City address,
			gender gen, side sd, Role role, Date dob, ScoreBating scoreBating) {
		super();
		this.playerid = playerid;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
		this.gen = gen;
		this.sd = sd;
		this.role = role;
		this.dob = dob;
		
	}

	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public side getSd() {
		return sd;
	}

	public void setSd(side sd) {
		this.sd = sd;
	}

	public String getPlayerid() {
		return playerid;
	}
	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public City getAddress() {
		return address;
	}
	public void setAddress(City address) {
		this.address = address;
	}
	public gender getGen() {
		return gen;
	}
	public void setGen(gender gen) {
		this.gen = gen;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Players [playerid=" + playerid + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", address=" + address + ", gen=" + gen + ", dob=" + dob + "]";
	}
	
}
