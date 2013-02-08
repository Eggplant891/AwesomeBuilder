package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class NautResDefinitions {
    public NautResources res;
    protected String [] _ability1;
    protected String _ability1Icon;
    protected String [] _ability2;
    protected String _ability2Icon;
    protected String [] _autoAttack;
    protected String _autoAttackIcon;
    protected String [] _utility;
    protected String _utilityIcon;
    protected String _fullPortrait;
    protected String _iconPortrait;
    protected String _nautNameCode;
    
    public NautResDefinitions() {
        res = new NautResources();        
    }
    
    public void LoadResources() {
        res.SetPortrait(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _fullPortrait));
        res.SetPortraitIcon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _iconPortrait));
        
        res.SetAbility1Icon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _ability1Icon));
        res.SetAbility2Icon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _ability2Icon));
        res.SetAutoAttackIcon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _autoAttackIcon));
        res.SetUtilityIcon(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _utilityIcon));
        
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i ++) {
            res.AddAbility1Slot(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _ability1[i]));
            res.AddAbility2Slot(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _ability2[i]));                
            res.AddAutoAttackSlot(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _autoAttack[i]));
            res.AddUtilitySlot(Global.m_assetManager.getImage("images/" + _nautNameCode + "/" + _utility[i]));
        }
    }
}
