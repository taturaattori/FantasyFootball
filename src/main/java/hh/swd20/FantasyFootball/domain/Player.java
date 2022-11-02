package hh.swd20.FantasyFootball.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long playerid;
	private String name;
	private int games;
	private int goals;
	private int assists;
	
	@ManyToOne
	@JoinColumn(name = "teamid")
	private Team team;

	//konstruktorit
	public Player(String name, int games, int goals, int assists, Team team) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", name=" + name + ", games=" + games + ", goals=" + goals
				+ ", assists=" + assists + ", team=" + team + "]";
	}
	
	
}
