package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;
import com.ronma.awesomecalc.naut.Ability;
import com.ronma.awesomecalc.naut.Naut;
import com.ronma.awesomecalc.naut.Upgrade;

public class NautResDefinitions {
    public NautResources res;
    protected LoadoutItemDefinition [] _ability1;
    protected String _ability1Icon;
    protected LoadoutItemDefinition [] _ability2;
    protected String _ability2Icon;
    protected LoadoutItemDefinition [] _autoAttack;
    protected String _autoAttackIcon;
    protected LoadoutItemDefinition [] _utility;
    protected String _utilityIcon;
    protected String _fullPortrait;
    protected String _iconPortrait;
    protected String _nautNameCode;
    protected String _nautFullName;
    
    public NautResDefinitions() {
        res = new NautResources();        
    }
    
//    public NautResDefinitions fillDefinitions(Naut n) {
//    	
//    	_nautNameCode = n.getCode();
//        _nautFullName = n.getName();
//        _fullPortrait = n.getResImgNameFull();
//        _iconPortrait = n.getResImgNameIcon();
//        
//        String imagePrefix = "images/" + n.getCode() + "/";
//        
//        Ability a = n.getAbilities().get(0);
//        _ability1Icon = a.getResImgName();
//        _ability1 = new LoadoutItemDefinition[6];
//        for(int i = 0; i < a.getUpgrades().size(); i++){
//        	Upgrade u = a.getUpgrades().get(i);
//        	_ability1[i] = new LoadoutItemDefinition(imagePrefix + u.getResImgName(), u.getName(), "---" + u.getName() + "---");
//        }
//        
//        a = n.getAbilities().get(1);
//        _ability2Icon = a.getResImgName();
//        _ability2 = new LoadoutItemDefinition[6];
//        for(int i = 0; i < a.getUpgrades().size(); i++){
//        	Upgrade u = a.getUpgrades().get(i);
//        	_ability2[i] = new LoadoutItemDefinition(imagePrefix + u.getResImgName(), u.getName(), "---" + u.getName() + "---");
//        }
//        
//        a = n.getAbilities().get(2);
//        _autoAttackIcon = a.getResImgName();
//        _autoAttack = new LoadoutItemDefinition[6];
//        for(int i = 0; i < a.getUpgrades().size(); i++){
//        	Upgrade u = a.getUpgrades().get(i);
//        	_autoAttack[i] = new LoadoutItemDefinition(imagePrefix + u.getResImgName(), u.getName(), "---" + u.getName() + "---");
//        }
//        
//        a = n.getAbilities().get(3);
//        _utilityIcon = a.getResImgName();
//        _utility = new LoadoutItemDefinition[6];
//        for(int i = 0; i < a.getUpgrades().size(); i++){
//        	Upgrade u = a.getUpgrades().get(i);
//        	_utility[i] = new LoadoutItemDefinition(imagePrefix + u.getResImgName(), u.getName(), "---" + u.getName() + "---");
//        }
//     
//        return this;
//	}



	public LoadoutItemDefinition GetItemDefinition(LoadoutRowType type, int col) {
        if (col < 0 || col > NautResources.NumSlotsPerAbility) return null;
        switch (type) {
            case ABILITY1:
                return _ability1[col];
                
            case ABILITY2:
                return _ability2[col];
            
            case AUTO_ATTACK:
                return _autoAttack[col];
            
            case UTILITY:
                return _utility[col];
        }
        return null;
    }
    
    public String GetNautName() {
        return _nautFullName;
    }
    
    public void LoadResources() {
        res.SetPortrait(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _fullPortrait));
        res.SetPortraitIcon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _iconPortrait));
        
        res.SetAbility1Icon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _ability1Icon));
        res.SetAbility2Icon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _ability2Icon));
        res.SetAutoAttackIcon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _autoAttackIcon));
        res.SetUtilityIcon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _utilityIcon));
        
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i ++) {
            res.AddSlot(LoadoutRowType.ABILITY1, _ability1[i].LoadImage());
            res.AddSlot(LoadoutRowType.ABILITY2, _ability2[i].LoadImage());                
            res.AddSlot(LoadoutRowType.AUTO_ATTACK, _autoAttack[i].LoadImage());
            res.AddSlot(LoadoutRowType.UTILITY, _utility[i].LoadImage());
            System.out.println("Loaded resource: " + _ability1[i].GetImagePath());
            System.out.println("Loaded resource: " + _ability2[i].GetImagePath());
            System.out.println("Loaded resource: " + _autoAttack[i].GetImagePath());
            System.out.println("Loaded resource: " + _utility[i].GetImagePath());
        }
    }
}
