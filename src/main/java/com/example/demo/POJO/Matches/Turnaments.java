package com.example.demo.POJO.Matches;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turnament")
public class Turnaments {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "score_id")
	private String turnamentid;
	@Column(name = "team1Name")
	private String team1Name;
	@Column(name = "team2Name")
	private String team2Name;
	@Column(name="Name")
	private String turnamentName;
	@OneToMany(targetEntity=MatchPlayer.class,cascade = CascadeType.ALL)  
	
	private List<MatchPlayer> team1;
	@OneToMany(targetEntity=MatchPlayer.class,cascade = CascadeType.ALL)  
	
	private List<MatchPlayer> team2;
	@Column(name = "formate")
	private Formate formate;
	@Column(name = "score1")
	private String score1;
	@Column(name = "score2")
	private String score2;
	public Turnaments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	



	public Turnaments(String turnamentid, String team1Name, String team2Name, String turnamentName,
			List<MatchPlayer> team1, List<MatchPlayer> team2, Formate formate, String score1, String score2) {
		super();
		this.turnamentid = turnamentid;
		this.team1Name = team1Name;
		this.team2Name = team2Name;
		this.turnamentName = turnamentName;
		this.team1 = team1;
		this.team2 = team2;
		this.formate = formate;
		this.score1 = score1;
		this.score2 = score2;
	}







	public List<MatchPlayer> getTeam1() {
		return team1;
	}







	public void setTeam1(List<MatchPlayer> team1) {
		this.team1 = team1;
	}







	public List<MatchPlayer> getTeam2() {
		return team2;
	}







	public void setTeam2(List<MatchPlayer> team2) {
		this.team2 = team2;
	}







	public Formate getFormate() {
		return formate;
	}



	public void setFormate(Formate formate) {
		this.formate = formate;
	}



	public String getScore1() {
		return score1;
	}



	public void setScore1(String score1) {
		this.score1 = score1;
	}



	public String getScore2() {
		return score2;
	}



	public void setScore2(String score2) {
		this.score2 = score2;
	}



	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public String getTurnamentid() {
		return turnamentid;
	}
	public void setTurnamentid(String turnamentid) {
		this.turnamentid = turnamentid;
	}
	public String getTurnamentName() {
		return turnamentName;
	}
	public void setTurnamentName(String turnamentName) {
		this.turnamentName = turnamentName;
	}
	
	
}
