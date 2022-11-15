package hh.swd20.FantasyFootball.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Player {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long playerid;
	@NotBlank(message = "Name is required!")
	private String name;
	@NotBlank(message = "Nationality is required!")
	private String nationality;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	private int games;
	private int goals;
	private int assists;
	
	@ManyToOne
	@JoinColumn(name = "teamid")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "leagueid")
	private League league;
	
	//konstruktorit
	public Player(String name, String nationality, Date birthdate, int games, int goals, int assists, Team team) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.games = games;
		this.goals = goals;
		this.assists = assists;
		this.team = team;
	}
	
	
	public Player() {
		
	}
		
	//getterit ja setterit
	public Long getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Long playerid) {
		this.playerid = playerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	

	public League getLeague() {
		return team.getLeague();
	}


	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", name=" + name + ", games=" + games + ", goals=" + goals
				+ ", assists=" + assists + ", team=" + team + "]";
	}
	
	
}
