package hh.swd20.FantasyFootball.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.FantasyFootball.domain.LeagueRepository;
import hh.swd20.FantasyFootball.domain.Player;
import hh.swd20.FantasyFootball.domain.PlayerRepository;
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
	
	@RequestMapping(value="/stats")
	public String statsPage(Model model) {
		model.addAttribute("players", repository.findAllByOrderByGoalsDesc());
		model.addAttribute("players2", repository.findAllByOrderByAssistsDesc());
		return "statspage";
	}
	
	@RequestMapping(value="/players")
	public String getPlayers(Model model) {
		model.addAttribute("players", repository.findAll());
		return "playerlist";
	}
	
	@RequestMapping(value="/leaguetable")
	public String getTable(Model model) {
		model.addAttribute("teams", trepository.findAll());
		return "leaguetable";
	}
	
	@RequestMapping(value = "/addplayer")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		//model.addAttribute("leagues", lrepository.findAll());
		model.addAttribute("teams", trepository.findAll());
		return "addplayer";
	}
	
	@RequestMapping(value = "/saveplayer", method = RequestMethod.POST)
    public String savePlayer(Player player){
        repository.save(player);
        return "redirect:players";
	}
	
	@RequestMapping(value = "/deleteplayer/{id}", method = RequestMethod.GET)
	public String deletePlayer(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../players";
	}
	
	@RequestMapping(value="/editplayer/{id}")
	public String editPlayer(@PathVariable("id") Long playerid, Model model) {
		model.addAttribute("player", repository.findById(playerid));
		model.addAttribute("teams", trepository.findAll());
		return "editplayer";
	}
	
	@RequestMapping(value = "/playerprofile/{id}")
	public String playerProfile(@PathVariable("id") Long id, Model model) {
		
		repository.findById(id).ifPresent(o -> model.addAttribute("player", o));
		return "playerprofile";
	}
	
}
