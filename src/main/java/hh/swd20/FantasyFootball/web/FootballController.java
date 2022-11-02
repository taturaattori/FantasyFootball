package hh.swd20.FantasyFootball.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.FantasyFootball.domain.PlayerRepository;
import hh.swd20.FantasyFootball.domain.TeamRepository;

@Controller
public class FootballController {

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private TeamRepository trepository;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		return "homepage";
	}
	
	@RequestMapping(value="/stats")
	public String statsPage(Model model) {
		model.addAttribute("players", repository.findAll());
		return "statspage";
	}
	
}
