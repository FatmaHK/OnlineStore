package com.SWE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Statistic;
import com.SWE.Entities.StoreAction;
import com.SWE.Repositories.StoreActionsRepo;

@CrossOrigin(origins = "*")
@RestController
public class StorePageController {
	@Autowired
	StoreActionsRepo actionsRepo;
	
	@GetMapping("/onlinemarket/undoAction/{id}")
	public void undoAction(Model model, @ModelAttribute StoreAction action) {
		model.addAttribute("action", new StoreAction());
		StoreCommand.actionsRepo = actionsRepo;
		StoreCommand.undo(action);
	}
}
