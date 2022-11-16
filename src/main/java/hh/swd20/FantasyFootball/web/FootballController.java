package hh.swd20.FantasyFootball.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.FantasyFootball.domain.LeagueRepository;
import hh.swd20.FantasyFootball.domain.Player;
import hh.swd20.FantasyFootball.domain.PlayerRepository;
import hh.swd20.FantasyFootball.domain.Team;
import hh.swd20.FantasyFootball.domain.TeamRepository;

@Controller
public class FootballController {

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private TeamRepository trepository;
	
	@Autowired
	private LeagueRepository lrepository;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		return "homepage";
	}
	
	// show players in order by goals and assists
	@RequestMapping(value="/stats")
	public String statsPage(Model model) {
		model.addAttribute("players", repository.findAllByOrderByGoalsDesc());
		model.addAttribute("players2", repository.findAllByOrderByAssistsDesc());
		return "statspage";
	}
	
	// show all players
	@RequestMapping(value="/players")
	public String getPlayers(Model model) {
		model.addAttribute("players", repository.findAll());
		return "playerlist";
	}
	
	// show teams in a league in order by points
	@RequestMapping(value="/leaguetable")
	public String getTable(Model model) {
		model.addAttribute("teams", trepository.findAllOrderByPointsDesc());
		return "leaguetable";
	}
	
	// add a new player
	@RequestMapping(value = "/addplayer")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		//model.addAttribute("leagues", lrepository.findAll());
		model.addAttribute("teams", trepository.findAll());
		return "addplayer";
	}
	
	// save player
	@RequestMapping(value = "/saveplayer", method = RequestMethod.POST)
    public String savePlayer(Player player){
        repository.save(player);
        return "redirect:players";
	}
	
	// delete player by playerid
	@RequestMapping(value = "/deleteplayer/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePlayer(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../players";
	}
	
	// edit player by player id
	@RequestMapping(value="/editplayer/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editPlayer(@PathVariable("id") Long playerid, Model model) {
		model.addAttribute("player", repository.findById(playerid));
		model.addAttribute("teams", trepository.findAll());
		return "editplayer";
	}
	
	// show attributes of a certain player by id
	@RequestMapping(value = "/playerprofile/{id}")
	public String playerProfile(@PathVariable("id") Long id, Model model) {
		
		repository.findById(id).ifPresent(o -> model.addAttribute("player", o));
		return "playerprofile";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	// REST-methods
	
	@RequestMapping(value = "/playerlist", method = RequestMethod.GET)
	public @ResponseBody List<Player> playerListRest() {
		return (List<Player>) repository.findAll();
	}
	
	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long playerid) {
		return repository.findById(playerid);
	}
	
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public @ResponseBody List<Team> teamListRest() {
		return (List<Team>) trepository.findAll();
	}
	
	@RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Team> findTeamRest(@PathVariable("id") Long teamid) {
		return trepository.findById(teamid);
	}
	
	
}
