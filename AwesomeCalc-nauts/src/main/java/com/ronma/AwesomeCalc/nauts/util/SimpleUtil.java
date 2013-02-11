package com.ronma.AwesomeCalc.nauts.util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ronma.AwesomeCalc.nauts.*;

public class SimpleUtil {

	public List<Naut> getNautsFromJSON(Reader jsonfileReader) {
		
		List<Naut> nauts = new ArrayList<Naut>();
		
		try {
			//NAUTS
			JSONParser p = new JSONParser();
			JSONArray nautData;
			nautData = (JSONArray) p.parse(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/naut.json"))));
			Iterator<JSONObject> nautIterator = nautData.iterator();
			while(nautIterator.hasNext()){
				JSONObject nautObj = nautIterator.next();
				Naut n = new Naut();
				n.setName((String)nautObj.get("name"));
				n.setAbilities(new ArrayList<Ability>());
				nauts.add(n);
				
				//ABILITIES
				JSONArray nautAbilities = (JSONArray) nautObj.get("abilities");
				Iterator<JSONObject> abilityIterator = nautAbilities.iterator();
				while(abilityIterator.hasNext()){
					JSONObject abilityObj = abilityIterator.next();
					Ability a = new Ability();
					a.setName((String)abilityObj.get("name"));
					a.setUpgrades(new ArrayList<Upgrade>());
					n.getAbilities().add(a);
					
					//ABILITIES
					JSONArray abilityUpgrades = (JSONArray) abilityObj.get("upgrades");
					Iterator<String> upgradeIterator = abilityUpgrades.iterator();
					while(upgradeIterator.hasNext()){
						String upgradeName = upgradeIterator.next();
						Upgrade u = new Upgrade();
						u.setName(upgradeName);
						a.getUpgrades().add(u);
					}
				}
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		return nauts;
		
	}
	
}
