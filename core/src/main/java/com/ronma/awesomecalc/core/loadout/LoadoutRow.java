package com.ronma.awesomecalc.core.loadout;

import playn.core.Image;
import com.ronma.awesomecalc.core.loadout.NautResources;
import com.ronma.awesomecalc.core.loadout.abilities.*;
import playn.core.Surface;
import java.util.ArrayList;

public class LoadoutRow {
    private LoadoutItem [] btns;
    private Image rowIcon;
    private ArrayList<LoadoutItem> selectedItems;
    private LoadoutRowType _type;
    private LoadoutItem abilityBtn;
    
    public static Image rowBG, rowClosedBG;
    
    public static final int xOffset = 16;
    public static int yOffset = 90 + 16;
    public static int xSpacing = 4;
    public static int ySpacing = 12;
    
    private int targetX, targetY;
    private int deniedTimer = 0;
    
    private LoadoutItem rowSelection = null;
    
    private final int iconPadding = 8;
    
    public LoadoutRow(LoadoutRowType type, NautResDefinitions resDef) {
        selectedItems = new ArrayList<LoadoutItem>();
        if (type == LoadoutRowType.ABILITY1 || type == LoadoutRowType.ABILITY2) {
            abilityBtn = new LoadoutItem(-1, resDef.GetAbilityDefinition(type), xOffset, yOffset + (type.ordinal() * (64 + ySpacing))) {
                @Override
                public void Clicked() {
                    Toggle();
                    UpdateSelectedItems();
                }
                
                @Override
                public void MouseHover() {
                    rowSelection = this;
                }
            };
        }
        btns = new LoadoutItem[NautResources.NumSlotsPerAbility];
        rowIcon = resDef.res.GetAbilityIcon(type);
        _type = type;
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            btns[i] = new LoadoutItem(i, resDef.GetItemDefinition(type, i),
                    xOffset + iconPadding + 64 + (i * (64 + xSpacing)),
                    yOffset + (type.ordinal() * (64 + ySpacing))) {
                @Override
                public void Clicked() {
                    if (selectedItems.size() < 3 && IsSwitchedOff()) {
                        Toggle();
                        UpdateSelectedItems();
                    }
                    else if (IsSwitchedOn()) {
                        Toggle();
                        UpdateSelectedItems();
                    }
                    else {
                        SelectionDenied(this);
                    }
                }
                
                @Override
                public void MouseHover() {
                    rowSelection = this;
                }
            };
        }
    }
    
    public int GetTotalCost() {
        int total = 0;
        if (abilityBtn == null || abilityBtn._state == true) {
            for (LoadoutItem l : selectedItems) {
                total += l.GetTotalCost();
            }
            
            if (abilityBtn != null) total += abilityBtn.GetTotalCost();
        }
        return total;
    }
    
    public void SelectionDenied(LoadoutToggleButton l) {
        targetX = l.GetX();
        targetY = l.GetY();
        deniedTimer = 30;
    }
    
    public void UpdateSelectedItems() {
        selectedItems.clear();
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            if (btns[i] != null) {
                if (btns[i].IsSwitchedOn()) {
                    if (selectedItems.size() < 3)
                        selectedItems.add(btns[i]);
                }
            }
        }
    }
    
    public LoadoutItem GetSelectedItem() {
        return rowSelection;
    }
    
    public void Update(float delta) {
        rowSelection = null;
        if (abilityBtn != null) abilityBtn.Update(delta);
        
        if (abilityBtn == null || abilityBtn._state == true) {
            for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
                btns[i].Update(delta);
            }
        }
        if (deniedTimer > 0) deniedTimer--;
    }
    
    public void Paint(Surface g) {
        if (abilityBtn == null || abilityBtn._state == true) {
            g.drawImage(rowBG, xOffset - 3, yOffset + (_type.ordinal() * (64 + ySpacing)) - 3);
        }
        else {
            g.drawImage(rowClosedBG, xOffset - 3, yOffset + (_type.ordinal() * (64 + ySpacing)) - 3);
        }
        if (abilityBtn != null) abilityBtn.Paint(g);
        else g.drawImage(rowIcon, xOffset, yOffset + (_type.ordinal() * (64 + ySpacing)));
        
        if (abilityBtn == null || abilityBtn._state == true) {
            for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
                btns[i].Paint(g);
            }
        }
        /*for (LoadoutItem l : selectedItems) {
            l.GetSprite().Draw(g, 550 + 64 * i, yOffset + (_type.ordinal() * 64), 1.0f, 1.0f);
            i++;
        }*/
        
        if (deniedTimer > 0) {
            g.drawImage(LoadoutScreen.selectionDenied, targetX, targetY);
        }
    }
}

