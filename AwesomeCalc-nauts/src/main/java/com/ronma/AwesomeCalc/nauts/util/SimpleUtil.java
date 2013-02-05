package com.ronma.AwesomeCalc.nauts.util;


import java.util.ArrayList;
import java.util.List;
import com.ronma.AwesomeCalc.nauts.*;

public class SimpleUtil {

	public static List<Naut> getNautsSimple(){
		
		String[] names = new String [] { "Clunk", "Coco" };
		
		List<Naut> nauts = new ArrayList<Naut>();
		
		Naut n;
		Ability a;
		Upgrade u;
		
		for(int i = 0; i < names.length; i ++){
			n = new Naut();
			n.setName(names[i]);
			n.setAbilities(new ArrayList<Ability>());
			
			a = new Ability();
			a.setName("Vacuum Bite");
			a.setUpgrades(new ArrayList<Upgrade>());
			
			u = new Upgrade();
			u.setName("Quick'n Cleaner");
			a.getUpgrades().add(u);
			
			n.getAbilities().add(a);
			
			nauts.add(n);
		}
		
		return nauts;
		
	}
	
}
