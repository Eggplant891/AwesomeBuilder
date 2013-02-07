package com.ronma.awesomecalc.core.loadout;

import playn.core.Image;
import java.util.ArrayList;
import playn.core.AssetWatcher;

public class NautResources {
    public final int NumSlotsPerAbility = 6;
    protected ArrayList<Image> _ability1;
    protected ArrayList<Image> _ability2;
    protected ArrayList<Image> _autoAttack;
    protected ArrayList<Image> _utility;
    protected Image _portraitIcon;
    protected Image _portraitFull;
    
    public NautResources() {
    
    }
    
    public void SetPortrait(Image img) {
        _portraitFull = img;
    }
    
    public void SetPortraitIcon(Image img) {
        _portraitIcon = img;
    }
    
    public void AddAbility1Slot(Image img) {
        if (_ability1 == null) _ability1 = new ArrayList<Image>();
        if (_ability1.size() <= NumSlotsPerAbility) {
            _ability1.add(img);
        }
    }
    
    public void AddAbility2Slot(Image img) {
        if (_ability2 == null) _ability2 = new ArrayList<Image>();
        if (_ability2.size() <= NumSlotsPerAbility) {
            _ability2.add(img);
        }
    }
    
    public void AddAutoAttackSlot(Image img) {
        if (_autoAttack == null) _autoAttack = new ArrayList<Image>();
        if (_autoAttack.size() <= NumSlotsPerAbility) {
            _autoAttack.add(img);
        }
    }
    
    public void AddUtilitySlot(Image img) {
        if (_utility == null) _utility = new ArrayList<Image>();
        if (_utility.size() <= NumSlotsPerAbility) {
            _utility.add(img);
        }
    }
    //////////////////////////////////////////////////////
    public Image GetPortrait() {
        return _portraitFull;
    }
    
    public Image GetPortraitIcon() {
        return _portraitIcon;
    }
    
    public Image GetAbility1Slot(int col) {
        if (_ability1 != null) {
            try {
                return _ability1.get(col);
            }
            catch (IndexOutOfBoundsException e) {}
        }
        
        return null;
    }
    
    public Image GetAbility2Slot(int col) {
        if (_ability2 != null) {
            try {
                return _ability2.get(col);
            }
            catch (IndexOutOfBoundsException e) {}
        }
        
        return null;
    }
    
    public Image GetAutoAttackSlot(int col) {
        if (_autoAttack != null) {
            try {
                return _autoAttack.get(col);
            }
            catch (IndexOutOfBoundsException e) {}
        }
        
        return null;
    }
    
    public Image GetUtilitySlot(int col) {
        if (_utility != null) {
            try {
                return _utility.get(col);
            }
            catch (IndexOutOfBoundsException e) {}
        }
        
        return null;
    }
    
    public ArrayList<Image> GetFullResourceList() {
        ArrayList<Image> fullList = new ArrayList<Image>();
        
        if (_ability1 != null)  fullList.addAll(_ability1);
        if (_ability2 != null)  fullList.addAll(_ability2);
        if (_autoAttack != null)fullList.addAll(_autoAttack);        
        if (_utility != null) fullList.addAll(_utility);
        if (_portraitFull != null) fullList.add(_portraitFull);
        if (_portraitIcon != null) fullList.add(_portraitIcon);
        
        return fullList;
    }
}
