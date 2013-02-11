package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

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
