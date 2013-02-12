package com.ronma.awesomecalc.core.util;

import com.ronma.awesomecalc.core.loadout.NautResDefinitions;
import com.ronma.AwesomeCalc.nauts.*;

public class LoudoutUtilities {

	
	public static NautResDefinitions generateDefinitionsFromNaut(Naut n){
		
		NautResDefinitions nrd = new NautResDefinitions().fillDefinitions(n);	
		return nrd;
	}
	
}
