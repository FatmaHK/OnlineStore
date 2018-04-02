package com.SWE.Entities;

import com.SWE.Controllers.IVisitor;

public interface IStatistics {
	public void acceptVisitor(IVisitor visitor);
}
