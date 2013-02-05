package com.ronma.AwesomeCalc.nauts.util;


import java.util.ArrayList;
import java.util.List;
import com.ronma.AwesomeCalc.nauts.*;

public class SimpleUtil {

	public static List<Naut> getNautsSimple(){
		
		String[][][] data = new String [][][] { 
				{ { "Clunk" }, {"Vacuum Bite", "Missiles", "Explode", "Jet Boost"} },
				{ { "Coco" }, {"Ball Lightning", "Shock", "Blaze", "Ollie"} },
				{ { "Derpl" }, {"Grid Trap", "Nuke", "Cat Shot", "Gatling", "Siege Mode", "Booster Rocket"} },
				{ { "Froggy G" }, {"Splash Dash", "Bolt .45 Fish-gun", "Tornado Move", "Frog Jump"} },
				{ { "Gnaw" }, {"Acid Spit", "Bite", "Grow Weedling", "Skroggle Jump"} },
				{ { "Leon" }, {"Tongue Snatch", "Slash", "Cloaking Skin", "Reptile Jump"} },
				{ { "Raelynn" }, {"Snipe", "Protoblaster", "Timerift", "Six Million Solar Human Jump"} },
				{ { "Lonestar" }, {"Dynamite Throw", "Blaster", "Summon Hyper Bull", "Double Jump"} },
				{ { "Skolldir" }, {"Mighty Throw", "Bash", "Earthquake", "Explosive Fart"} },
				{ { "Vinnie & Spike" }, {"Smoke Screen", "Bubble Gun", "Spike Dive", "Inflate"} },
				{ { "Voltar" }, {"Smoke Screen", "Shock", "Blaze", "Ollie"} },
				{ { "Yuri" }, {"Suicide Drones", "Healing Wave", "Healbot", "Hover"} }
		};
		
		List<Naut> nauts = new ArrayList<Naut>();
		
		Naut n;
		Ability a;
		Upgrade u;
		
		for(int i = 0; i < data.length; i ++){
			n = new Naut();
			n.setName(data[i][0][0]);
			n.setAbilities(new ArrayList<Ability>());
			
			for(int j = 0; j < data[i][1].length; j++){
				a = new Ability();
				a.setName(data[i][1][j]);
				a.setUpgrades(new ArrayList<Upgrade>());
				
				u = new Upgrade();
				u.setName("Quick'n Cleaner");
				a.getUpgrades().add(u);
				
				n.getAbilities().add(a);
			}
			
			nauts.add(n);
		}
		
		return nauts;
		
	}
	
}
