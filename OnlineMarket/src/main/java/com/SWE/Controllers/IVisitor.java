package com.SWE.Controllers;

import com.SWE.Entities.Brand;
import com.SWE.Entities.Product;
import com.SWE.Entities.User;

public interface IVisitor {
	
	public void visit(Product p);
	public void visit(Brand b);
	public void visit(User u);
}

