package com.ronma.AwesomeCalc.nauts.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ronma.AwesomeCalc.nauts.*;

public class SimpleUtil {

	public List<Naut> getNautsSimple() {
		
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
		
		try {
			JSONParser p = new JSONParser();
			JSONArray nautData;
			nautData = (JSONArray) p.parse(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/naut.json"))));
			System.out.println("json:" + nautData);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
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
	
	public String getNautJson(){
		return "[{\"name\":\"Clunk\",\"abilities\":[{\"name\":\"Vacuum Bite\",\"upgrades\":[\"Quick\'n Cleaner\",\"Medical Pump\",\"Multi Hose\",\"Screamer Engine\",\"Power Converter\",\"The Suckanator Power 9000 Cleaner\"]},{\"name\":\"Explode\",\"upgrades\":[\"Thermonuclear Cleaner\",\"Titanium Hard Hat\",\"Grease Lightning Snail\",\"Blueprints container\",\"Reactor Cooler\",\"Universal Charger\"]},{\"name\":\"Missiles\",\"upgrades\":[\"Fragmenting Shells\",\"Free Flight Fins\",\"Missile Barrage\",\"The Juggernaut \\\"Fat Pete\\\"\",\"Improved Homing Sensor\",\"Salvo Value Pack\"]},{\"name\":\"Jet Boost\",\"upgrades\":[\"Power Pills Turbo\",\"Med-i\'-can\",\"Space Air Max\",\"Solar Tree\",\"Piggy Bank\",\"Power Pills\"]}]},{\"name\":\"Coco Nebulon\",\"abilities\":[{\"name\":\"Ball Lightning\",\"upgrades\":[\"Voltage Amplifier\",\"Gyroscopic Dynamo\",\"Thunder Striker\",\"Conducting Gel\",\"Flashing Lights\",\"Heavenly Fire\"]},{\"name\":\"Blaze\",\"upgrades\":[\"Silver Coating\",\"Chuck\'s Board\",\"Disruptor\",\"Time Travel Turbine\",\"Syphon Disruptor\",\"Wave Raiser\"]},{\"name\":\"Shock\",\"upgrades\":[\"Static Gloves\",\"Flexible Heat Sinks\",\"Wetsuit\",\"Power Gloves\",\"Hoover Hands\",\"Super Conductor\"]},{\"name\":\"Ollie\",\"upgrades\":[\"Power Pills Turbo\",\"Med-i\'-can\",\"Space Air Max\",\"Solar Tree\",\"Piggy Bank\",\"Power Pills\"]}]},{\"name\":\"Derpl Zork\",\"abilities\":[{\"name\":\"Grid Trap \\\\ Nuke\",\"upgrades\":[\"Empowered Grid\",\"Strengthened Trap\",\"Hydrocollision Lava Lamp\",\"Combustion Lava Lamp\",\"Lead Casing\",\"Super-powered Grid\"]},{\"name\":\"Siege Mode\",\"upgrades\":[\"Sniper Bullets\",\"Force Field\",\"Solid Fist Bullets\",\"Hollow Point Bullets\",\"Deployment Pads\",\"Brim Force Field\"]},{\"name\":\"Cat Shot \\\\ Gatling\",\"upgrades\":[\"Longcat\",\"Kitty Catsuit\",\"CAT Package\",\"CatCat\",\"Hover Cat\",\"Bat Catsuit\"]},{\"name\":\"Booster Rocket\",\"upgrades\":[\"Power Pills Turbo\",\"Med-i\'-can\",\"Space Air Max\",\"Solar Tree\",\"Piggy Bank\",\"Power Pills\"]}]}]";
	}
	
}
