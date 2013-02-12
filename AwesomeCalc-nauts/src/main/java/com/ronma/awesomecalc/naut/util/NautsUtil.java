package com.ronma.awesomecalc.naut.util;


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

import com.ronma.awesomecalc.naut.Ability;
import com.ronma.awesomecalc.naut.Naut;
import com.ronma.awesomecalc.naut.Upgrade;

public class NautsUtil {
	
	public Naut getNautFromJSON(String jsonPath){
		BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(jsonPath)));
		return getNautFromJSON(r);
	}
	
	public Naut getNautFromJSON(Reader jsonfileReader){
		Naut n = new Naut();
		
		try {
			//NAUTS
			JSONParser p = new JSONParser();
			JSONArray nautData;
			JSONObject nautObj = (JSONObject) p.parse(jsonfileReader);
			n.setName((String)nautObj.get("name"));
			n.setCode((String)nautObj.get("code"));
			n.setResImgNameFull((String)nautObj.get("img_full"));
			n.setResImgNameIcon((String)nautObj.get("img_icon"));
			n.setAbilities(new ArrayList<Ability>());
			
			//ABILITIES
			JSONArray nautAbilities = (JSONArray) nautObj.get("abilities");
			Iterator<JSONObject> abilityIterator = nautAbilities.iterator();
			while(abilityIterator.hasNext()){
				JSONObject abilityObj = abilityIterator.next();
				Ability a = new Ability();
				a.setName((String)abilityObj.get("name"));
				a.setResImgName((String)abilityObj.get("img_icon"));
				a.setUpgrades(new ArrayList<Upgrade>());
				n.getAbilities().add(a);
				
				//ABILITIES
				JSONArray abilityUpgrades = (JSONArray) abilityObj.get("upgrades");
				Iterator<JSONObject> upgradeIterator = abilityUpgrades.iterator();
				while(upgradeIterator.hasNext()){
					JSONObject upgradeObj = upgradeIterator.next();
					Upgrade u = new Upgrade();
					u.setName((String)upgradeObj.get("name"));
					u.setResImgName((String)upgradeObj.get("img_icon"));
					a.getUpgrades().add(u);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		} catch (Exception e){
			System.out.println(e);
		}
		
		return n;
	}

	public List<Naut> getNautsFromJSON(Reader jsonfileReader) {
		
		List<Naut> nauts = new ArrayList<Naut>();
		
		try {
			//NAUTS
			JSONParser p = new JSONParser();
			JSONArray nautData;
			nautData = (JSONArray) p.parse(jsonfileReader);
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
