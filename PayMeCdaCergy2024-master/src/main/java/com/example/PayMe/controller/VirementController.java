package com.example.PayMe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.PayMe.model.User;
import com.example.PayMe.model.Virement;
import com.example.PayMe.service.UserService;
import com.example.PayMe.service.VirementService;

@Controller
public class VirementController {

	@Autowired
	VirementService virementService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/virements")
	public String getVirementsPage(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("virements", virementService.getVirementListByUserName(userName));
		model.addAttribute("virement", new Virement());
		return "virementsPage";
	}
	
	@PostMapping("/virements")
	public String createVirement(Model model, Virement virement){

		User user = userService.getConnectedUser();
		
		virement.setUser(user);
		virement.setDate(new Date());
		virementService.save(virement);
		user.changeAmount(virement.getAmount());
		userService.save(user);
		
		model.addAttribute("virements", virementService.getVirementListByUserName(user.getName()));
		model.addAttribute("virement", new Virement());
		return "virementsPage";
		}
	//.Il faudra aller chercher dans le context le user connecté. 
	
	//.Il faudra créer et sauvegarger un objet de type virement avec les infos du formulaire. 
	//.Il faudra éditer et sauvegarder l'amount du user.
}
