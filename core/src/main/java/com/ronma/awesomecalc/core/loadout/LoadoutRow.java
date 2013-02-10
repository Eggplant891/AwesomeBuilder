package com.ronma.awesomecalc.core.loadout;

import playn.core.Image;
import com.ronma.awesomecalc.core.loadout.NautResources;
import playn.core.Surface;
import java.util.ArrayList;

public class LoadoutRow {
    private LoadoutItem [] btns;
    private Image rowIcon;
    private int itemsSelected;
    private ArrayList<LoadoutItem> selectedItems;
    private LoadoutRowType _type;
    
    public static Image rowBG;
    
    public static final int xOffset = 16;
    public static int yOffset = 90 + 16;
    public static int xSpacing = 4;
    public static int ySpacing = 12;
    
    private LoadoutItem rowSelection = null;
    
    private final int iconPadding = 8;
    
    public LoadoutRow(LoadoutRowType type, NautResDefinitions resDef) {
        itemsSelected = 0;
        selectedItems = new ArrayList<LoadoutItem>();
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
                }
                
                @Override
                public void MouseHover() {
                    rowSelection = this;
                }
            };
        }
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
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            btns[i].Update(delta);
        }
    }
    
    public void Paint(Surface g) {
        g.drawImage(rowBG, xOffset - 4, yOffset + (_type.ordinal() * (64 + ySpacing)) - 3);
        g.drawImage(rowIcon, xOffset, yOffset + (_type.ordinal() * (64 + ySpacing)));
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            btns[i].Paint(g);
        }
        int i = 0;
        for (LoadoutItem l : selectedItems) {
            l.GetSprite().Draw(g, 550 + 64 * i, yOffset + (_type.ordinal() * 64), 1.0f, 1.0f);
            i++;
        }
    }
}
