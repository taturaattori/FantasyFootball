package hh.swd20.FantasyFootball.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	
	//autogeneroituva id
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long teamid;
	private String name;
	private int games;
	private int wins;
	private int losses;
	private int draws;
	
	
	@ManyToOne
	@JoinColumn(name = "leagueid")
	private League league;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	private List<Player> players;
	
	//konstruktorit
	public Team(String name, int games, int wins, int losses, int draws, League league) {
		super();
		this.name = name;
		this.games = games;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.league = league;
	}
	
	public Team(String name, League league) {
		super();
		this.name = name;
		this.league = league;
	}
	
	public Team() {
		
	}
	// getterit ja setterit
	public Long getTeamid() {
		return teamid;
	}
	public void setTeamid(Long teamid) {
		this.teamid = teamid;
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
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	

	public int getPoints() {
		return (wins * 3) + draws;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [id=" + teamid + ", name=" + name + ", games=" + games + ", wins=" + wins + ", losses=" + losses
				+ ", draws=" + draws + "]";
	}
	
}
