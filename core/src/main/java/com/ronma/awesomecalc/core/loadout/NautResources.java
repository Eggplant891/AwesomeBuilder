package com.ronma.awesomecalc.core.loadout;

import playn.core.Image;
import java.util.ArrayList;
import com.ronma.awesomecalc.core.loadout.LoadoutRow;

public class NautResources {
    public static final int NumSlotsPerAbility = 6;
    protected Image _ability1Icon;
    protected ArrayList<Image> _ability1;
    protected Image _ability2Icon;
    protected ArrayList<Image> _ability2;
    protected Image _autoAttackIcon;
    protected ArrayList<Image> _autoAttack;
    protected Image _utilityIcon;
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
    
    public void SetIcon(LoadoutRowType type, Image img) {
        switch (type) {
            case ABILITY1:
                SetAbility1Icon(img);
            break;

            case ABILITY2:
                SetAbility2Icon(img);
            break;

            case AUTO_ATTACK:
                SetAutoAttackIcon(img);
            break;

            case UTILITY:
                SetUtilityIcon(img);
            break;
        }
    }
    
    public void SetAbility1Icon(Image img) {
        _ability1Icon = img;
    }
    public void SetAbility2Icon(Image img) {
        _ability2Icon = img;
    }
    public void SetAutoAttackIcon(Image img) {
        _autoAttackIcon = img;
    }
    public void SetUtilityIcon(Image img) {
        _utilityIcon = img;
    }
    
    public void AddSlot(LoadoutRowType type, Image img) {
        switch (type) {
            case ABILITY1:
                AddAbility1Slot(img);
            break;
                
            case ABILITY2:
                AddAbility2Slot(img);
            break;
                
            case AUTO_ATTACK:
                AddAutoAttackSlot(img);
            break;
                
            case UTILITY:
                AddUtilitySlot(img);
            break;
        }
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
    
    public Image GetAbilityIcon(LoadoutRowType type) {
        switch (type) {
            case ABILITY1:
                return GetAbility1Icon();
                
            case ABILITY2:
                return GetAbility2Icon();
                
            case AUTO_ATTACK:
                return GetAutoAttackIcon();
                
            case UTILITY: 
                return GetUtilityIcon();
        }
        
        return null;
    }
        
    
    public Image GetAbility1Icon() {
        return _ability1Icon;
    }
    public Image GetAbility2Icon() {
        return _ability2Icon;
    }
    public Image GetAutoAttackIcon() {
        return _autoAttackIcon;
    }
    public Image GetUtilityIcon() {
        return _utilityIcon;
    }
    
    public Image GetSlot(LoadoutRowType type, int col) {
        switch (type) {
            case ABILITY1:
                return GetAbility1Slot(col);
                
            case ABILITY2:
                return GetAbility2Slot(col);
                
            case AUTO_ATTACK:
                return GetAutoAttackSlot(col);
                
            case UTILITY: 
                return GetUtilitySlot(col);
        }
        
        return null;
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
        
        if (_ability1Icon != null) fullList.add(_ability1Icon);
        if (_ability2Icon != null) fullList.add(_ability2Icon);
        if (_autoAttackIcon != null) fullList.add(_autoAttackIcon);
        if (_utilityIcon != null) fullList.add(_utilityIcon);
        
        if (_ability1 != null)  fullList.addAll(_ability1);
        if (_ability2 != null)  fullList.addAll(_ability2);
        if (_autoAttack != null)fullList.addAll(_autoAttack);        
        if (_utility != null) fullList.addAll(_utility);
        
        if (_portraitFull != null) fullList.add(_portraitFull);
        if (_portraitIcon != null) fullList.add(_portraitIcon);
        
        return fullList;
    }
}
