package com.SWE.Controllers;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Brand;
import com.SWE.Entities.Product;
import com.SWE.Entities.*;
import com.SWE.Repositories.StatisticsRepo;
import com.SWE.Repositories.StoreActionsRepo;

@CrossOrigin(origins = "*")
@RestController
public abstract class StoreCommand {
	
	protected StoreController sc;
	public static StoreActionsRepo actionsRepo;
	
	public StoreController getSc() {
		return sc;
	}
	public void setSc(StoreController sc) {
		this.sc = sc;
	}	
	
	public static void undo(StoreAction s_action) {
//		s_action= actionsRepo.findOne(s_action.getId());
//		s_action.setUndoAble(true);
//		actionsRepo.save(s_action);
	}	
//	public abstract boolean execute(int pID, int sID);
	
	public boolean execute(String sName, int bId, Model model, Brand newbrand) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean execute(String sName, int pId, Model model, Product newproduct) {
		// TODO Auto-generated method stub
		return false;
	}
}
